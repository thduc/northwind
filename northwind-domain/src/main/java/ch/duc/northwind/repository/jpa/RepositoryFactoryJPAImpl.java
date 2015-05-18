package ch.duc.northwind.repository.jpa;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import ch.duc.northwind.domain.Category;
import ch.duc.northwind.domain.Product;
import ch.duc.northwind.repository.Repository;
import ch.duc.northwind.repository.RepositoryFactory;

public class RepositoryFactoryJPAImpl extends RepositoryFactory {
	@Inject
	private EntityManager entityMananger;
	
	@Override
	public Repository<Category, Integer> getCategoryRepository() {
		RepositoryJPAImpl<Category, Integer> repo = new RepositoryJPAImpl<Category, Integer>(Category.class);
		repo.entityManager = entityMananger;
		return repo;
	}

	@Override
	public Repository<Product, Integer> getProductRepository() {
		RepositoryJPAImpl<Product, Integer> repo = new RepositoryJPAImpl<Product, Integer>(Product.class);
		repo.entityManager = entityMananger;
		return repo;
	}
}
