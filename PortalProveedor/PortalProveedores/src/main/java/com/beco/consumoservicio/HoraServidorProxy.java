package com.beco.consumoservicio;

public class HoraServidorProxy implements com.beco.consumoservicio.HoraServidor {
  private String _endpoint = null;
  private com.beco.consumoservicio.HoraServidor horaServidor = null;
  
  public HoraServidorProxy() {
    _initHoraServidorProxy();
  }
  
  public HoraServidorProxy(String endpoint) {
    _endpoint = endpoint;
    _initHoraServidorProxy();
  }
  
  private void _initHoraServidorProxy() {
    try {
    HoraServidorServiceLocator hsl =  new HoraServidorServiceLocator();
    horaServidor = hsl.getHoraServidor();
      //horaServidor = (new HoraServidorServiceLocator()).getHoraServidor()
      if (horaServidor != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)horaServidor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)horaServidor)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (horaServidor != null)
      ((javax.xml.rpc.Stub)horaServidor)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.beco.consumoservicio.HoraServidor getHoraServidor() {
    if (horaServidor == null)
      _initHoraServidorProxy();
    return horaServidor;
  }
  
  public java.lang.String responderHora(java.lang.String par) throws java.rmi.RemoteException{
    if (horaServidor == null)
      _initHoraServidorProxy();
    return horaServidor.responderHora(par);
  }
  
  
}