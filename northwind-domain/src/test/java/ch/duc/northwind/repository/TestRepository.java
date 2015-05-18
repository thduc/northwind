package ch.duc.northwind.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ch.duc.northwind.domain.Category;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;

public class TestRepository {
	
	private Injector injector;
	
	@Before
	public void init() {
		injector = Guice.createInjector(new JPAImplModule(), new JpaPersistModule("northwind-domain"));
		//start persistence
	    injector.getInstance(PersistService.class).start();
	}
	
	@After
	public void shutdonw() {
		//stop persistence
//		injector.getInstance(EntityManagerFactory.class).close();
		injector.getInstance(PersistService.class).stop();
	}
	
	@Test
	public void testCustomer() {
		CustomerRepository repository = injector.getInstance(CustomerRepository.class);
		assertNotNull(repository);
		assertNotNull(repository.find("ALFKI"));
	}
	
	@Test
	public void testCategory() {
		RepositoryFactory f = injector.getInstance(RepositoryFactory.class);
		Repository<Category, Integer> repository = f.getCategoryRepository();
		assertNotNull(repository);
		assertNotNull(repository.find(1));
	}
}
