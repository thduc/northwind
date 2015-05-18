package ch.duc.northwind.logic;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import ch.duc.northwind.domain.Customer;
import ch.duc.northwind.repository.CustomerRepository;

@Named
public class CustomerService {
	@Inject 
	private CustomerRepository customerRepository;
	
	public Customer findCustomer(String customerId) {
		return customerRepository.find(customerId);
	}
	
	public List<Customer> findCustomers(int firstResult, int maxResult) {
		return customerRepository.findCustomers(firstResult, maxResult);
	}
	
	public long countCustomers() {
		return customerRepository.count();
	}
}
