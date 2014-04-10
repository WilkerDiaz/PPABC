package com.beco.portalproveedores.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.beco.portalproveedores.bean.Attachment;
import com.beco.portalproveedores.bean.Category;
import com.beco.portalproveedores.bean.CommercialAgreement;
import com.beco.portalproveedores.bean.Country;
import com.beco.portalproveedores.bean.Department;
import com.beco.portalproveedores.bean.Line;
import com.beco.portalproveedores.bean.Origin;
import com.beco.portalproveedores.bean.Permission;
import com.beco.portalproveedores.bean.Product;
import com.beco.portalproveedores.bean.ProductProspect;
import com.beco.portalproveedores.bean.Prospect;
import com.beco.portalproveedores.bean.ProspectCategory;
import com.beco.portalproveedores.bean.ProspectDepartment;
import com.beco.portalproveedores.bean.ProspectLine;
import com.beco.portalproveedores.bean.ProspectSection;
import com.beco.portalproveedores.bean.Role;
import com.beco.portalproveedores.bean.RolePermission;
import com.beco.portalproveedores.bean.RoleUserPortal;
import com.beco.portalproveedores.bean.Section;
import com.beco.portalproveedores.bean.Status;
//import com.abc.ws.bean.XxWabHomepage;


/*
 * DAO Helper
 */
public class HibernateHelper{
	
	private static SessionFactory sessionFactory;
	public static ServiceRegistry serviceRegistry;
	private static final Log log = LogFactory.getLog(HibernateHelper.class);
	
	
	public HibernateHelper() {
		
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
	}
	
	//##############  PROSPECT  #####################
	
	public void saveProspect(Prospect prospect){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.save(prospect); //<|--- Aqui guardamos el objeto en la base de datos.
		 
		session.getTransaction().commit();
		session.close();
	}
	
	public Prospect getProspectById(Number id){
		
		BigDecimal bd = new BigDecimal(id.toString());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		Prospect prospect= (Prospect)session.get(Prospect.class,bd);
		 
		session.getTransaction().commit();
		session.close();
		return prospect;
	}
	
	@SuppressWarnings("unchecked")
	public Prospect[] getProspectByComName(String name){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String query = "SELECT pro FROM Prospect pro " +
				"where " +
				"pro.commercialName = '" + name+"'";
		
		List<Prospect> result = session.createQuery(query).list();
	    
	    Prospect[] array = new Prospect[result.size()];
	    array = result.toArray(array);
	    
		session.getTransaction().commit();
		session.close();
		return array;
	}
	
	@SuppressWarnings("unchecked")
	public Prospect[] getAllProspects(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String query = "SELECT pro FROM Prospect pro";
		
		List<Prospect> result = session.createQuery(query).list();
	    
	    Prospect[] array = new Prospect[result.size()];
	    array = result.toArray(array);
	    
		session.getTransaction().commit();
		session.close();
		return array;
	}
	
	public String deleteProspect(Prospect prospect){
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.delete(prospect);
		 
		session.getTransaction().commit();
		session.close();
		return "prospecto borrado";
	}
	
	public void updateProspect(Prospect prospect){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.update(prospect); //<|--- Aqui guardamos el objeto en la base de datos.
		 
		session.getTransaction().commit();
		session.close();
	}
	
	public void saveOrUpdateProspect(Prospect prospect){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.saveOrUpdate(prospect); //<|--- Aqui guardamos el objeto en la base de datos.
		 
		session.getTransaction().commit();
		session.close();
	}
	
	//##############  ATTACHMENT  #####################
	
	public void saveAttachment(Attachment attachment){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.save(attachment); //<|--- Aqui guardamos el objeto en la base de datos.
		 
		session.getTransaction().commit();
		session.close();
	}
	
	public Attachment getAttachmentById(Number id){
		
		BigDecimal bd = new BigDecimal(id.toString());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		Attachment attachment= (Attachment)session.get(Attachment.class,bd);
		 
		session.getTransaction().commit();
		session.close();
		return attachment;
	}
	
	@SuppressWarnings("unchecked")
	public Attachment[] getAttachmentByComName(String name){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String query = "SELECT att FROM Attachment att " +
				"where " +
				"att.Name = " + name;
		
		List<Attachment> result = session.createQuery(query).list();
	    
		Attachment[] array = new Attachment[result.size()];
	    array = result.toArray(array);
	    
		session.getTransaction().commit();
		session.close();
		return array;
	}
	
	public String deleteAttachment(Attachment attachment){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.delete(attachment);
		 
		session.getTransaction().commit();
		session.close();
		return "Adjunto borrado";
	}
	
	public void updateAttachment(Attachment attachment){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.update(attachment); //<|--- Aqui guardamos el objeto en la base de datos.
		 
		session.getTransaction().commit();
		session.close();
	}
	
	//##############  COMMERCIAL AGREEMENT  #####################
	
	public void saveCommercialAgreement(CommercialAgreement commercialAgreement){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.save(commercialAgreement); //<|--- Aqui guardamos el objeto en la base de datos.
		 
		session.getTransaction().commit();
		session.close();
	}
	
	public CommercialAgreement getCommercialAgreementById(Number id){
		
		BigDecimal bd = new BigDecimal(id.toString());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		CommercialAgreement commercialAgreement= (CommercialAgreement)session.get(CommercialAgreement.class,bd);
		 
		session.getTransaction().commit();
		session.close();
		return commercialAgreement;
	}
	
	@SuppressWarnings("unchecked")
	public CommercialAgreement[] getCommercialAgreementByComName(String name){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String query = "SELECT com FROM CommercialAgreement com " +
				"where " +
				"com.CommercialAgreementId = " + name;
		
		List<CommercialAgreement> result = session.createQuery(query).list();
	    
		CommercialAgreement[] array = new CommercialAgreement[result.size()];
	    array = result.toArray(array);
	    
		session.getTransaction().commit();
		session.close();
		return array;
	}
	
	public String deleteCommercialAgreement(CommercialAgreement commercialAgreement){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.delete(commercialAgreement);
		 
		session.getTransaction().commit();
		session.close();
		return "CommercialAgreement borrado";
	}
	
	public void updateCommercialAgreement(CommercialAgreement commercialAgreement){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.update(commercialAgreement); //<|--- Aqui guardamos el objeto en la base de datos.
		 
		session.getTransaction().commit();
		session.close();
	}
	
	//##############  PERMISSION  #####################
	
	public void savePermission(Permission permission){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.save(permission); //<|--- Aqui guardamos el objeto en la base de datos.
		 
		session.getTransaction().commit();
		session.close();
	}
	
	public Permission getPermissionById(Number id){
		
		BigDecimal bd = new BigDecimal(id.toString());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		Permission permission= (Permission)session.get(Permission.class,bd);
		 
		session.getTransaction().commit();
		session.close();
		return permission;
	}
	
	@SuppressWarnings("unchecked")
	public Permission[] getPermissionByComName(String name){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String query = "SELECT per FROM Permission per " +
				"where " +
				"per.commercialName = " + name;
		
		List<Permission> result = session.createQuery(query).list();
	    
		Permission[] array = new Permission[result.size()];
	    array = result.toArray(array);
	    
		session.getTransaction().commit();
		session.close();
		return array;
	}
	
	public String deletePermission(Permission permission){
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.delete(permission);
		 
		session.getTransaction().commit();
		session.close();
		return "permission borrado";
	}
	
	public void updatePermission(Permission permission){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.update(permission); //<|--- Aqui guardamos el objeto en la base de datos.
		 
		session.getTransaction().commit();
		session.close();
	}
	
	//##############  PRODUCT  #####################
	
	public void saveProduct(Product product){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.save(product); //<|--- Aqui guardamos el objeto en la base de datos.
		 
		session.getTransaction().commit();
		session.close();
	}
	
	public Product getProductById(Number id){
		
		BigDecimal bd = new BigDecimal(id.toString());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		Product product= (Product)session.get(Product.class,bd);
		 
		session.getTransaction().commit();
		session.close();
		return product;
	}
	
	@SuppressWarnings("unchecked")
	public Product[] getProductByComName(String name){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String query = "SELECT pro FROM Product pro " +
				"where " +
				"pro.commercialName = " + name;
		
		List<Product> result = session.createQuery(query).list();
	    
		Product[] array = new Product[result.size()];
	    array = result.toArray(array);
	    
		session.getTransaction().commit();
		session.close();
		return array;
	}
	
	public String deleteProduct(Product product){
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.delete(product);
		 
		session.getTransaction().commit();
		session.close();
		return "product borrado";
	}
	
	public void updateproduct(Product product){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.update(product); //<|--- Aqui guardamos el objeto en la base de datos.
		 
		session.getTransaction().commit();
		session.close();
	}
	
	//##############  PRODUCT PROSPECT  #####################
	
	public void saveProductProspect(ProductProspect productProspect){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.save(productProspect); //<|--- Aqui guardamos el objeto en la base de datos.
		 
		session.getTransaction().commit();
		session.close();
	}
	
	public ProductProspect getProductProspectById(Number id){
		
		BigDecimal bd = new BigDecimal(id.toString());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		ProductProspect productProspect= (ProductProspect)session.get(ProductProspect.class,bd);
		 
		session.getTransaction().commit();
		session.close();
		return productProspect;
	}
	
	@SuppressWarnings("unchecked")
	public ProductProspect[] getProductProspectByComName(String name){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		String query = "SELECT pro FROM ProductProspect pro " +
				"where " +
				"pro.commercialName = " + name;
		
		List<ProductProspect> result = session.createQuery(query).list();
	    
		ProductProspect[] array = new ProductProspect[result.size()];
	    array = result.toArray(array);
	    
		session.getTransaction().commit();
		session.close();
		return array;
	}
	
	public String deleteProductProspect(ProductProspect productProspect){
		
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.delete(productProspect);
		 
		session.getTransaction().commit();
		session.close();
		return "prospecto borrado";
	}
	
	public void updateProductProspect(ProductProspect productProspect){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		 
		session.update(productProspect); //<|--- Aqui guardamos el objeto en la base de datos.
		 
		session.getTransaction().commit();
		session.close();
	}
	
	//##############  ROLE  #####################
	
		public void saveRole(Role role){
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			 
			session.save(role); //<|--- Aqui guardamos el objeto en la base de datos.
			 
			session.getTransaction().commit();
			session.close();
		}
		
		public Role getRoleById(Number id){
			
			BigDecimal bd = new BigDecimal(id.toString());
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			 
			Role role= (Role)session.get(Role.class,bd);
			 
			session.getTransaction().commit();
			session.close();
			return role;
		}
		
		@SuppressWarnings("unchecked")
		public Role[] getRoleByComName(String name){
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			String query = "SELECT rol FROM Role rol " +
					"where " +
					"rol.commercialName = " + name;
			
			List<Role> result = session.createQuery(query).list();
		    
			Role[] array = new Role[result.size()];
		    array = result.toArray(array);
		    
			session.getTransaction().commit();
			session.close();
			return array;
		}
		
		public String deleteRole(Role role){
			
			
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			 
			session.delete(role);
			 
			session.getTransaction().commit();
			session.close();
			return "Role borrado";
		}
		
		public void updateRole(Role role){
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			 
			session.update(role); //<|--- Aqui guardamos el objeto en la base de datos.
			 
			session.getTransaction().commit();
			session.close();
		}
	
		
		//##############  ROLE PERMISSION  #####################
		
		public void saveRolePermission(RolePermission rolePermission){
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			 
			session.save(rolePermission); //<|--- Aqui guardamos el objeto en la base de datos.
			 
			session.getTransaction().commit();
			session.close();
		}
		
		public RolePermission getRolePermissionById(Number id){
			
			BigDecimal bd = new BigDecimal(id.toString());
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			 
			RolePermission rolePermission= (RolePermission)session.get(RolePermission.class,bd);
			 
			session.getTransaction().commit();
			session.close();
			return rolePermission;
		}
		
		@SuppressWarnings("unchecked")
		public RolePermission[] getRolePermissionByComName(String name){
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			String query = "SELECT pro FROM RolePermission pro " +
					"where " +
					"pro.commercialName = " + name;
			
			List<RolePermission> result = session.createQuery(query).list();
		    
			RolePermission[] array = new RolePermission[result.size()];
		    array = result.toArray(array);
		    
			session.getTransaction().commit();
			session.close();
			return array;
		}
		
		public String deleteRolePermission(RolePermission rolePermission){
			
			
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			 
			session.delete(rolePermission);
			 
			session.getTransaction().commit();
			session.close();
			return "RolePermission borrado";
		}
		
		public void updateRolePermission(RolePermission rolePermission){
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			 
			session.update(rolePermission); //<|--- Aqui guardamos el objeto en la base de datos.
			 
			session.getTransaction().commit();
			session.close();
		}
		
		//##############  ROLE USER PORTAL  #####################
		
		public void saveRoleUserPortal(RoleUserPortal roleUserPortal){
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			 
			session.save(roleUserPortal); //<|--- Aqui guardamos el objeto en la base de datos.
			 
			session.getTransaction().commit();
			session.close();
		}
		
		public RoleUserPortal getRoleUserPortalById(Number id){
			
			BigDecimal bd = new BigDecimal(id.toString());
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			 
			RoleUserPortal roleUserPortal= (RoleUserPortal)session.get(RoleUserPortal.class,bd);
			 
			session.getTransaction().commit();
			session.close();
			return roleUserPortal;
		}
		
		@SuppressWarnings("unchecked")
		public RoleUserPortal[] getRoleUserPortalByComName(String name){
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			
			String query = "SELECT pro FROM RoleUserPortal pro " +
					"where " +
					"pro.commercialName = " + name;
			
			List<RoleUserPortal> result = session.createQuery(query).list();
		    
			RoleUserPortal[] array = new RoleUserPortal[result.size()];
		    array = result.toArray(array);
		    
			session.getTransaction().commit();
			session.close();
			return array;
		}
		
		public String deleteRoleUserPortal(RoleUserPortal roleUserPortal){
			
			
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			 
			session.delete(roleUserPortal);
			 
			session.getTransaction().commit();
			session.close();
			return "RoleUserPortal borrado";
		}
		
		public void updateRoleUserPortal(RoleUserPortal roleUserPortal){
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			 
			session.update(roleUserPortal); //<|--- Aqui guardamos el objeto en la base de datos.
			 
			session.getTransaction().commit();
			session.close();
		}
		
		
		//##############  COUNTRY  #####################
		
				public void saveCountry(Country country){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.save(country); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				public Country getCountryById(Number id){
					
					BigDecimal bd = new BigDecimal(id.toString());
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					Country country= (Country)session.get(Country.class,bd);
					 
					session.getTransaction().commit();
					session.close();
					return country;
				}
				
				@SuppressWarnings("unchecked")
				public Country[] getCountryByName(String name){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM Country pro " +
							"where " +
							"pro.Name = " + name;
					
					List<Country> result = session.createQuery(query).list();
				    
					Country[] array = new Country[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
				public String deleteCountry(Country country){
					
					
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.delete(country);
					 
					session.getTransaction().commit();
					session.close();
					return "Country borrado";
				}
				
				public void updateCountry(Country country){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.update(country); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				@SuppressWarnings("unchecked")
				public Country[] getAllCountrys(){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM Country pro";
					
					List<Country> result = session.createQuery(query).list();
				    
					System.out.println("el arreglo de paises tiene "+ result.size());
					
					Country[] array = new Country[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
		
				//##############  ORIGIN  #####################
				
				public void saveOrigin(Origin origin){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.save(origin); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				public Origin getOriginById(Number id){
					
					BigDecimal bd = new BigDecimal(id.toString());
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					Origin origin= (Origin)session.get(Origin.class,bd);
					 
					session.getTransaction().commit();
					session.close();
					return origin;
				}
				
				@SuppressWarnings("unchecked")
				public Origin[] getOriginByName(String name){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM Origin pro " +
							"where " +
							"pro.Name = " + name;
					
					List<Origin> result = session.createQuery(query).list();
				    
					Origin[] array = new Origin[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
				public String deleteOrigin(Origin origin){
					
					
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.delete(origin);
					 
					session.getTransaction().commit();
					session.close();
					return "Origin borrado";
				}
				
				public void updateOrigin(Origin origin){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.update(origin); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				@SuppressWarnings("unchecked")
				public Origin[] getAllOrigins(){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM Origin pro";
					
					List<Origin> result = session.createQuery(query).list();
				    
					System.out.println("el arreglo de procedencias tiene "+ result.size());
					
					Origin[] array = new Origin[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
				//##############  STATUS  #####################
				
				public void saveStatus(Status status){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.save(status); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				public Status getStatusById(Number id){
					
					BigDecimal bd = new BigDecimal(id.toString());
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					Status status= (Status)session.get(Status.class,bd);
					 
					session.getTransaction().commit();
					session.close();
					return status;
				}
				
				@SuppressWarnings("unchecked")
				public Status[] getStatusByName(String name){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM Status pro " +
							"where " +
							"pro.Name = " + name;
					
					List<Status> result = session.createQuery(query).list();
				    
					Status[] array = new Status[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
				public String deleteStatus(Status status){
					
					
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.delete(status);
					 
					session.getTransaction().commit();
					session.close();
					return "Status borrado";
				}
				
				public void updateStatus(Status status){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.update(status); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				@SuppressWarnings("unchecked")
				public Status[] getAllStatus(){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM Status pro";
					
					List<Status> result = session.createQuery(query).list();
				    
					System.out.println("el arreglo de estados tiene "+ result.size());
					
					Status[] array = new Status[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
				//##############  CATEGORY  #####################
				
				public void saveCategory(Category category){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.save(category); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				public Category getCategoryById(Number id){
					
					BigDecimal bd = new BigDecimal(id.toString());
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					Category category= (Category)session.get(Category.class,bd);
					 
					session.getTransaction().commit();
					session.close();
					return category;
				}
				
				@SuppressWarnings("unchecked")
				public Category[] getCategoryByName(String name){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM Category pro " +
							"where " +
							"pro.categoryName = '" + name+"'";
					
					List<Category> result = session.createQuery(query).list();
				    
					Category[] array = new Category[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
				public String deleteCategory(Category category){
					
					
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.delete(category);
					 
					session.getTransaction().commit();
					session.close();
					return "Category borrado";
				}
				
				public void updateCategory(Category category){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.update(category); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				@SuppressWarnings("unchecked")
				public Category[] getAllCategory(){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM Category pro";
					
					List<Category> result = session.createQuery(query).list();
				    
					System.out.println("el arreglo de categorias tiene "+ result.size());
					
					Category[] array = new Category[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
				
//##############  DEPARTMENT  #####################
				
				public void saveDepartment(Department department){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.save(department); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				public Department getDepartmentById(Number id){
					
					BigDecimal bd = new BigDecimal(id.toString());
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					Department department= (Department)session.get(Department.class,bd);
					 
					session.getTransaction().commit();
					session.close();
					return department;
				}
				
				@SuppressWarnings("unchecked")
				public Department[] getDepartmentByName(String name){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM Department pro " +
							"where " +
							"pro.departmentName = '" + name+"'";
					
					List<Department> result = session.createQuery(query).list();
				    
					Department[] array = new Department[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
				public String deleteDepartment(Department department){
					
					
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.delete(department);
					 
					session.getTransaction().commit();
					session.close();
					return "Department borrado";
				}
				
				public void updateDepartment(Department department){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.update(department); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				@SuppressWarnings("unchecked")
				public Department[] getAllDepartment(){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM Department pro";
					
					List<Department> result = session.createQuery(query).list();
				    
					System.out.println("el arreglo de departamentos tiene "+ result.size());
					
					Department[] array = new Department[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
				
//##############  LINE  #####################
				
				public void saveLine(Line line){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.save(line); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				public Line getLineById(Number id){
					
					BigDecimal bd = new BigDecimal(id.toString());
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					Line line= (Line)session.get(Line.class,bd);
					 
					session.getTransaction().commit();
					session.close();
					return line;
				}
				
				@SuppressWarnings("unchecked")
				public Line[] getLineByName(String name){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM Line pro " +
							"where " +
							"pro.lineName = '" + name+"'";
					
					List<Line> result = session.createQuery(query).list();
				    
					Line[] array = new Line[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
				public String deleteLine(Line line){
					
					
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.delete(line);
					 
					session.getTransaction().commit();
					session.close();
					return "Line borrado";
				}
				
				public void updateLine(Line line){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.update(line); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				@SuppressWarnings("unchecked")
				public Line[] getAllLine(){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM Line pro";
					
					List<Line> result = session.createQuery(query).list();
				    
					System.out.println("el arreglo de lineas tiene "+ result.size());
					
					Line[] array = new Line[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
//##############  SECTION  #####################
				
				public void saveSection(Section section){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.save(section); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				public Section getSectionById(Number id){
					
					BigDecimal bd = new BigDecimal(id.toString());
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					Section section= (Section)session.get(Section.class,bd);
					 
					session.getTransaction().commit();
					session.close();
					return section;
				}
				
				@SuppressWarnings("unchecked")
				public Section[] getSectionByName(String name){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM Section pro " +
							"where " +
							"pro.sectionName = '" + name+"'";
					
					List<Section> result = session.createQuery(query).list();
				    
					Section[] array = new Section[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
				public String deleteSection(Section section){
					
					
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.delete(section);
					 
					session.getTransaction().commit();
					session.close();
					return "Section borrado";
				}
				
				public void updateSection(Section section){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.update(section); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				@SuppressWarnings("unchecked")
				public Section[] getAllSection(){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM Section pro";
					
					List<Section> result = session.createQuery(query).list();
				    
					System.out.println("el arreglo de secciones tiene "+ result.size());
					
					Section[] array = new Section[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
//##############  PROSPECT CATEGORY  #####################
				
				public void saveProspectCategory(ProspectCategory prospectCategory){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.save(prospectCategory); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				public ProspectCategory getProspectCategoryById(Number id){
					
					BigDecimal bd = new BigDecimal(id.toString());
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					ProspectCategory prospectCategory= (ProspectCategory)session.get(ProspectCategory.class,bd);
					 
					session.getTransaction().commit();
					session.close();
					return prospectCategory;
				}
				
				@SuppressWarnings("unchecked")
				public ProspectCategory[] getProspectCategoryByName(String name){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM ProspectCategory pro " +
							"where " +
							"pro.Name = " + name;
					
					List<ProspectCategory> result = session.createQuery(query).list();
				    
					ProspectCategory[] array = new ProspectCategory[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
				public String deleteProspectCategory(ProspectCategory prospectCategory){
					
					
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.delete(prospectCategory);
					 
					session.getTransaction().commit();
					session.close();
					return "ProspectCategory borrado";
				}
				
				public void updateProspectCategory(ProspectCategory prospectCategory){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.update(prospectCategory); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				@SuppressWarnings("unchecked")
				public ProspectCategory[] getAllProspectCategory(){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM ProspectCategory pro";
					
					List<ProspectCategory> result = session.createQuery(query).list();
				    
					System.out.println("el arreglo de secciones tiene "+ result.size());
					
					ProspectCategory[] array = new ProspectCategory[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
				@SuppressWarnings("unchecked")
				public Category[] getCategoryByProspect(Prospect paramProspect){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro.category FROM ProspectCategory pro "
							+ "where pro.prospect = '"+paramProspect.getProspectId()+"'";
					
					List<Category> result = session.createQuery(query).list();
				    
					System.out.println("el arreglo de categorias tiene "+ result.size());
					
					Category[] array = new Category[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
//##############  PROSPECT DEPARTMENT  #####################
				
				public void saveProspectDepartment(ProspectDepartment prospectDepartment){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.save(prospectDepartment); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				public ProspectDepartment getProspectDepartmentById(Number id){
					
					BigDecimal bd = new BigDecimal(id.toString());
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					ProspectDepartment prospectDepartment= (ProspectDepartment)session.get(ProspectDepartment.class,bd);
					 
					session.getTransaction().commit();
					session.close();
					return prospectDepartment;
				}
				
				@SuppressWarnings("unchecked")
				public ProspectDepartment[] getProspectDepartmentByName(String name){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM ProspectDepartment pro " +
							"where " +
							"pro.DepartmentName = '" + name+"'";
					
					List<ProspectDepartment> result = session.createQuery(query).list();
				    
					ProspectDepartment[] array = new ProspectDepartment[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
				public String deleteProspectDepartment(ProspectDepartment prospectDepartment){
					
					
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.delete(prospectDepartment);
					 
					session.getTransaction().commit();
					session.close();
					return "ProspectDepartment borrado";
				}
				
				public void updateProspectDepartment(ProspectDepartment prospectDepartment){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.update(prospectDepartment); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				@SuppressWarnings("unchecked")
				public ProspectDepartment[] getAllProspectDepartment(){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM ProspectDepartment pro";
					
					List<ProspectDepartment> result = session.createQuery(query).list();
				    
					System.out.println("el arreglo de secciones tiene "+ result.size());
					
					ProspectDepartment[] array = new ProspectDepartment[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
//##############  PROSPECT LINE  #####################
				
				public void saveProspectLine(ProspectLine prospectLine){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.save(prospectLine); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				public ProspectLine getProspectLineById(Number id){
					
					BigDecimal bd = new BigDecimal(id.toString());
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					ProspectLine prospectLine = (ProspectLine)session.get(ProspectLine.class,bd);
					 
					session.getTransaction().commit();
					session.close();
					return prospectLine;
				}
				
				@SuppressWarnings("unchecked")
				public ProspectLine[] getProspectLineByName(String name){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM ProspectLine pro " +
							"where " +
							"pro.LineName = " + name;
					
					List<ProspectLine> result = session.createQuery(query).list();
				    
					ProspectLine[] array = new ProspectLine[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
				public String deleteProspectLine(ProspectLine prospectLine){
					
					
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.delete(prospectLine);
					 
					session.getTransaction().commit();
					session.close();
					return "ProspectLine borrado";
				}
				
				public void updateProspectLine(ProspectLine prospectLine){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.update(prospectLine); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				@SuppressWarnings("unchecked")
				public ProspectLine[] getAllProspectLine(){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM ProspectLine pro";
					
					List<ProspectLine> result = session.createQuery(query).list();
				    
					System.out.println("el arreglo de secciones tiene "+ result.size());
					
					ProspectLine[] array = new ProspectLine[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
				
//##############  PROSPECT SECTION  #####################
				
				public void saveProspectSection(ProspectSection prospectSection){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.save(prospectSection); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				public ProspectSection getProspectSectionById(Number id){
					
					BigDecimal bd = new BigDecimal(id.toString());
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					ProspectSection prospectSection = (ProspectSection)session.get(ProspectSection.class,bd);
					 
					session.getTransaction().commit();
					session.close();
					return prospectSection;
				}
				
				@SuppressWarnings("unchecked")
				public ProspectSection[] getProspectSectionByName(String name){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM ProspectSection pro " +
							"where " +
							"pro.SectionName = " + name;
					
					List<ProspectSection> result = session.createQuery(query).list();
				    
					ProspectSection[] array = new ProspectSection[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
				
				public String deleteProspectSection(ProspectSection prospectSection){
					
					
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.delete(prospectSection);
					 
					session.getTransaction().commit();
					session.close();
					return "ProspectSection borrado";
				}
				
				public void updateProspectSection(ProspectSection prospectSection){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					 
					session.update(prospectSection); //<|--- Aqui guardamos el objeto en la base de datos.
					 
					session.getTransaction().commit();
					session.close();
				}
				
				@SuppressWarnings("unchecked")
				public ProspectSection[] getAllProspectSection(){
					Session session = sessionFactory.openSession();
					session.beginTransaction();
					
					String query = "SELECT pro FROM ProspectSection pro";
					
					List<ProspectSection> result = session.createQuery(query).list();
				    
					System.out.println("el arreglo de secciones tiene "+ result.size());
					
					ProspectSection[] array = new ProspectSection[result.size()];
				    array = result.toArray(array);
				    
					session.getTransaction().commit();
					session.close();
					return array;
				}
}
