package ch.duc.northwind.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.AbstractEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import ch.duc.northwind.repository.CustomerRepository;
import ch.duc.northwind.repository.jpa.CustomerRepositoryJPAImpl;

@Configuration
@ComponentScan(basePackages={"ch.duc.northwind.repository.jpa"})
public class PersistenceConfig {

	@Bean
	public AbstractEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
		emfb.setPersistenceUnitName("northwind-domain");
		return emfb;
	}
//	
//	@Bean
//	public EntityManagerFactory entityManagerFactory(AbstractEntityManagerFactoryBean emfb) {
//		return emfb.getNativeEntityManagerFactory();
//	}
	
	@Bean
	public EntityManager entityManager(EntityManagerFactory emf) {
		return emf.createEntityManager();
	}
	
	@Bean
	public CustomerRepository customerRepository() {
		return new CustomerRepositoryJPAImpl();
	}
	
//	
//	@Bean
//	public DAOSpitter daoSpitter(EntityManager em) {
//		return new JPASpitter(em);
//	}
//	
//	@Bean
//	public DAOSpittle daoSpittle(EntityManager em) {
//		return new JPASpittle(em);
//	}
}
