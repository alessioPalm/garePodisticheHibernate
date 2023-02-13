package persistenza;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory=creaSessionFactory();
	private static StandardServiceRegistry registry;
	
	public static SessionFactory creaSessionFactory () {
		
		try {

			 // Create registry
			registry = new StandardServiceRegistryBuilder().configure().build();

			// Create MetadataSources
			MetadataSources sources = new MetadataSources(registry);

			// Create Metadata
			Metadata metadata = sources.getMetadataBuilder().build();

			// Create SessionFactory
			sessionFactory = metadata.getSessionFactoryBuilder().build();
			System.out.println(sessionFactory);
			
			return sessionFactory;
			
		}catch (Exception e) {
			e.printStackTrace();
			if(registry != null) {
				StandardServiceRegistryBuilder.destroy(registry); //disrtuggiamo il registro
			}
		}
		return null;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void setSessionFactory(SessionFactory sessionFactory) {
		HibernateUtil.sessionFactory = sessionFactory;
	}

	public static StandardServiceRegistry getRegistry() {
		return registry;
	}

	public static void setRegistry(StandardServiceRegistry registry) {
		HibernateUtil.registry = registry;
	}
}
