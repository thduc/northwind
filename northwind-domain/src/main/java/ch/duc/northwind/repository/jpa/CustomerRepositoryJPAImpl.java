package ch.duc.northwind.repository.jpa;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ch.duc.northwind.domain.Customer;
import ch.duc.northwind.domain.Customer_;
import ch.duc.northwind.repository.CustomerRepository;

public class CustomerRepositoryJPAImpl extends RepositoryJPAImpl<Customer, String> implements CustomerRepository {
	public CustomerRepositoryJPAImpl() {
		super(Customer.class);
	}

	@Override
	public List<Customer> findCustomers(int firstResult, int maxResult) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(domainClass);
		Root<Customer> r = cq.from(domainClass);
		cq.select(r);
		cq.orderBy(cb.asc(r.get(Customer_.id)));
		TypedQuery<Customer> q = entityManager.createQuery(cq);
		setFirstAndMaxResult(q, firstResult, maxResult);
		return q.getResultList();
	}
}
