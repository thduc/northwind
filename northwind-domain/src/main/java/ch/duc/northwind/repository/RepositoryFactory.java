package ch.duc.northwind.repository;

import ch.duc.northwind.domain.Category;
import ch.duc.northwind.domain.Product;

public abstract class RepositoryFactory {
	public abstract Repository<Category, Integer> getCategoryRepository();
	public abstract Repository<Product, Integer> getProductRepository();
}
