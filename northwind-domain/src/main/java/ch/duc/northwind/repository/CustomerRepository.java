package ch.duc.northwind.repository;

import java.util.List;

import ch.duc.northwind.domain.Customer;

public interface CustomerRepository extends Repository<Customer, String> {
	List<Customer> findCustomers(int firstResult, int maxResult);
}
