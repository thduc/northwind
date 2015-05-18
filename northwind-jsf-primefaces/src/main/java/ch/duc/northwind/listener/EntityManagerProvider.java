package ch.duc.northwind.listener;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class EntityManagerProvider implements ServletContextListener {
	private static EntityManagerFactory emf = null;
	
	private void init() {
//		System.out.println("Create EntityManagerFactory");
		emf = Persistence.createEntityManagerFactory("northwind-domain");
//		System.out.println("EntityManagerFactory created: " + emf);
		getEntityManager();
	}
	
	private void close() {
		if (emf != null) {
			emf.close();
		}
	}
	
	@Produces
	public EntityManager getEntityManager() {
		if (emf == null) {
			throw new IllegalStateException("Context is not initialized yet.");
		}
		return emf.createEntityManager();
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		close();
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		init();
	}
}
