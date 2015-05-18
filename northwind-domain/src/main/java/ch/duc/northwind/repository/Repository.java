package ch.duc.northwind.repository;

import java.io.Serializable;
import java.util.List;

public interface Repository<T, K extends Serializable> {
	void save(T entity);
	T find(K id);
	List<T> find();
//	void update(T entity);
	void delete(T entity);
	void delete(K id);
	long count();
}
