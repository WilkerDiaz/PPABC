package com.waliria.sistemas;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.logging.Level;

import org.compiere.Compiere;
import org.compiere.common.FieldType;
import org.compiere.model.MClient;
import org.compiere.model.MPInstance;
import org.compiere.model.MPInstancePara;
import org.compiere.model.MProcess;
import org.compiere.model.MSystem;
import org.compiere.process.ProcessInfo;
import org.compiere.server.CompiereServerMgr;
import org.compiere.util.CLogMgt;
import org.compiere.util.Ctx;
import org.compiere.util.DB;
import org.compiere.util.Env;
import org.compiere.util.Login;
import org.compiere.util.Trx;

/**
 * Clase para publicar el contenido de un proceso en un web service
 * @author jgraterol
 *
 */
public class ProcessPublisher {

	public Ctx				m_ctx = null;
	public static MSystem 	p_system = null;
	public MClient			p_client = null;
	/** Logger for class MScheduler */
    private static final org.compiere.util.CLogger log = org.compiere.util.CLogger.getCLogger(ProcessPublisher.class);
    public Trx m_trx;
	
   /**
    * Interpreta los datos del proceso a ejecutar en compiere y lo invoca
    * @param AD_Client_ID Cliente en Compiere
    * @param ProcessName Proceso a ejecutar
    * @param User Usuario que debe ejecutarlo
    * @param InstanceName Aplicación que ejecuta el proceso
    * @param parametersKey Listado de claves de los parametros (nombres)
    * @param parametersValue Listado de valores de los parametros
    * @return
    */
	public String manageProcess(int AD_Client_ID, String ProcessName, String User, String InstanceName, String[] parametersKey, String[] parametersValue){
		
		System.out.println("Iniciando ejecución del proceso");
		
		//Inicializando compiere
		Compiere.startup(false);
		System.out.println("Iniciando ejecución del proceso2");
		CLogMgt.setLevel(Level.FINER);
		System.out.println("Iniciando ejecución del proceso3");
		CompiereServerMgr.getServer();
		
		System.out.println("Inicializado Compiere");
		
		//Construyendo el contexto
		this.m_ctx = new Ctx(Env.getCtx());
		if (p_system == null)
			p_system = MSystem.get(this.m_ctx);
		this.p_client = MClient.get(this.m_ctx);
		
		// Obtener AD_Client_ID desde el CompiereProcessor (Agenda)
		this.m_ctx.setContext("#AD_Client_ID", AD_Client_ID);
		Ctx ctx = Env.getCtx();
		ctx.setAD_Client_ID(AD_Client_ID);
		ctx.setContext("AD_Client_ID", AD_Client_ID);
		ctx.setAD_Org_ID(0);
		ctx.setContext("AD_Org_ID", 0);
		
		System.out.println("Inicializado el contexto");
		
		int AD_User_ID =0;
		int AD_Process_ID=0;
		
		//Interpretando parámetros
		PreparedStatement psQuery = null;
		ResultSet rsQuery = null;
		String SQLUsuario = "select AD_User_ID from AD_User where name='"+User+"'";
		
		try{
			psQuery = DB.prepareStatement(SQLUsuario, null);
			rsQuery = psQuery.executeQuery();
			while(rsQuery.next()){	
				AD_User_ID = rsQuery.getInt("AD_User_ID");
			}//WHILE		
		} //try	elementos
		catch(SQLException e){	
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rsQuery);
			DB.closeStatement(psQuery);
		}
		System.out.println(DB.getDatabase().getName()+" "+DB.getDatabase().getSchema()+" "+ DB.getDatabase().getDescription());
		System.out.println("Obtenido el ID del usuario");
		
		PreparedStatement psQuery2 = null;
		ResultSet rsQuery2 = null;
		String SQLUsuario2 = "select AD_Process_ID from ad_process where name='"+ProcessName+"'";
		
		try{
			psQuery2 = DB.prepareStatement(SQLUsuario2, null);
			rsQuery2 = psQuery2.executeQuery();
			while(rsQuery2.next()){	
				AD_Process_ID = rsQuery2.getInt("AD_Process_ID");
			}//WHILE		
		} //try	elementos
		catch(SQLException e){	
			e.printStackTrace();
		}
		finally {
			DB.closeResultSet(rsQuery2);
			DB.closeStatement(psQuery2);
		}
		
		System.out.println("Obtenido el ID del proceso");
		
		//Actualizando el contexto
		ctx.setAD_User_ID(AD_User_ID);
		ctx.setContext("AD_User_ID",AD_User_ID);
		ctx.setContext("#SalesRep_ID", AD_User_ID);
		// Agregar variables Globales de XX_VSI_KeyNameInfo a contexto de los
		// procesos del manejador de Tareas (Ojo, solo disponible para BECO)
		Login.cargaID(ctx);
		
		System.out.println("Cargadas variables en el contexto");
		
		//Ejecutar el proceso solicitado por el usuario
		return executeProcess(AD_Client_ID, AD_Process_ID, AD_User_ID, InstanceName, parametersKey, parametersValue);
	}

	
	/**
	 * Ejecuta el proceso
	 * @param AD_Client_ID
	 * @param AD_Process_ID
	 * @param AD_User_ID
	 * @param InstanceName
	 * @param parametersKey
	 * @param parametersValue
	 * @return
	 */
	private String executeProcess(int AD_Client_ID, int AD_Process_ID, int AD_User_ID, String InstanceName, String[] parametersKey, String[] parametersValue) {
		MProcess process =  new MProcess (Env.getCtx(), AD_Process_ID, null);
		this.m_trx = Trx.get(InstanceName);
		log.info(process.toString());
		int AD_Table_ID = 0;
		int Record_ID = 0;
		MPInstance pInstance = new MPInstance(process, Record_ID);
		String error = fillParameter(process, pInstance, parametersKey, parametersValue);
		if (error != null)
		{
			return error;
		}
		ProcessInfo pi = new ProcessInfo (process.getName(), process.getAD_Process_ID(),
			AD_Table_ID, Record_ID);
		pi.setAD_User_ID(AD_User_ID);
		pi.setAD_Client_ID(AD_Client_ID);
		pi.setAD_PInstance_ID(pInstance.getAD_PInstance_ID());
		process.processIt(pi, this.m_trx);
		return pi.getSummary();
	}
	
	
	/**
	 * Asigna al proceso los parámetros que requiere. Si el valor recibido para un parámetro es
	 * nulo, intenta ubicarlo en el contexto de la aplicación
	 * @param pInstance Instancia del proceso
	 * @param parametersKey Listado de claves de los parámetros
	 * @param parametersValue Listado de valores de los parametros
	 * @return
	 */
	private String fillParameter(MProcess process, MPInstance pInstance, String[] parametersKey, String[] parametersValue)
	{
		
		StringBuffer sb = null;
		MPInstancePara[] iParams = pInstance.getParameters();
		for (MPInstancePara iPara : iParams)
		{
			for (int i=0; i<parametersKey.length; i++)
			{
				String parameterKey = parametersKey[i];
				if (iPara.getParameterName().equals(parameterKey))
				{
					String variable = parametersValue[i];
					log.fine(parameterKey + " = " + variable);
					//	Value - Constant/Variable
					String value = variable;
					if ((variable == null)
						|| ((variable != null) && (variable.length() == 0)))
						value = null;
					else if (variable.indexOf("@") != -1)	//	we may have a variable
					{
						//	Strip
						int index = variable.indexOf("@");
						String columnName = variable.substring(index+1);
						index = columnName.indexOf("@");
						if (index != -1)
						{
							columnName = columnName.substring(0, index);
							//	try Env
							String env = Env.getCtx().getContext(columnName);
							if (env.length() == 0)
							{
								log.warning(parameterKey
									+ " - not in environment =" + columnName
									+ "(" + variable + ") - ignored");
								break;
							}
							else
								value = env;
						}
					}	//	@variable@

					//	No Value
					if (value == null)
					{
						String env = Env.getCtx().getContext(parameterKey);
						if (env.length() == 0)
						{
							log.warning(parameterKey
								+ " - not in environment =" + parameterKey
								+ "(" + variable + ") - ignored");
							break;
						}
						else
							value = env;
						break;
					}

					//Convertir de String al tipo de dato que requiere el proceso
					try
					{
						int dataType = process.getParameter(iPara.getParameterName()).getAD_Reference_ID();
						if (FieldType.isNumeric(dataType)
							|| FieldType.isID(dataType))
						{
							BigDecimal bd = new BigDecimal (value);
							iPara.setP_Number(bd);
							log.fine(iPara.getParameterName()
								+ " = " + variable + " (=" + bd + "=)");
						}
						else if (FieldType.isDate(dataType))
						{
							Timestamp ts = Timestamp.valueOf(value);
							iPara.setP_Date(ts);
							log.fine(iPara.getParameterName()
								+ " = " + variable + " (=" + ts + "=)");
						}
						else
						{
							iPara.setP_String(value);
							log.fine(iPara.getParameterName()
								+ " = " + variable
								+ " (=" + value + "=) " + value.getClass().getName());
						}
						if (!iPara.save())
							log.warning("Not Saved - " +iPara.getParameterName());
					}
					catch (Exception e)
					{
						String msg = iPara.getParameterName()
							+ " = " + variable + " (" + value
							+ ") " + value.getClass().getName()
							+ " - " + e.getLocalizedMessage();
						log.warning(msg);
						if (sb == null)
							sb = new StringBuffer(msg);
						else
							sb.append("; ").append(msg);
					}
					break;
				}	//	parameter match
			}	//	scheduler parameter loop
		}	//	instance parameter loop
		if (sb == null)
			return null;
		return sb.toString();
	}	//	fillParameter
	
	
	public static void main(String[] args){
		ProcessPublisher publisher =  new ProcessPublisher();
		String[] parametersKey = {"XX_WVP_Description","XX_WVP_IntPrueba"};
		String[] parametersValue = {"Prueba con jtrias", "777"};
		
		publisher.manageProcess(1000012, "XX_WVP_ProcesoPrueba", "JGRATEROL", "Proceso de prueba", parametersKey, parametersValue);
	}
	
}
