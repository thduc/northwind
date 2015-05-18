package ch.duc.northwind.repository;

import ch.duc.northwind.repository.jpa.CustomerRepositoryJPAImpl;
import ch.duc.northwind.repository.jpa.RepositoryFactoryJPAImpl;

import com.google.inject.AbstractModule;

public class JPAImplModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(CustomerRepository.class).to(CustomerRepositoryJPAImpl.class);
		bind(RepositoryFactory.class).to(RepositoryFactoryJPAImpl.class);
	}
}
