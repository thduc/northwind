package ch.duc.northwind.repository.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ch.duc.northwind.repository.Repository;

public class RepositoryJPAImpl<T, K extends Serializable> implements Repository<T, K> {
	
	protected Class<T> domainClass;
	
	@Inject
	@PersistenceContext(unitName="northwind-domain")
	protected EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public RepositoryJPAImpl() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		domainClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}
	
	public RepositoryJPAImpl(Class<T> domainClass) {
		super();
		this.domainClass = domainClass;
	}

	@Override
	public void save(T entity) {
		entityManager.persist(entity);
	}

	@Override
	public T find(K id) {
		return entityManager.find(domainClass, id);
	}

	@Override
	public List<T> find() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> c = cb.createQuery(domainClass);
		Root<T> root = c.from(domainClass);
		c.select(root);
		TypedQuery<T> q = entityManager.createQuery(c);
		return q.getResultList();
	}

	@Override
	public void delete(T entity) {
		entityManager.remove(entity);
	}

	@Override
	public void delete(K id) {
		T entity = find(id);
		if (entity != null) {
			entityManager.remove(entity);
		}
	}

	@Override
	public long count() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> c = cb.createQuery(Long.class);
		Root<T> root = c.from(domainClass);
		c.select(cb.count(root));
		TypedQuery<Long> q = entityManager.createQuery(c);
		return q.getSingleResult();
	}
	
	protected void setFirstAndMaxResult(Query q, int firstResult, int maxResult) {
		if (firstResult >= 0) {
			q.setFirstResult(firstResult);
		}
		if (maxResult > 0) {
			q.setMaxResults(maxResult);
		}
	}
}
