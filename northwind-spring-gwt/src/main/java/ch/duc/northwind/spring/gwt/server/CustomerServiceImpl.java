package ch.duc.northwind.spring.gwt.server;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ch.duc.northwind.domain.Customer;
import ch.duc.northwind.spring.gwt.client.CustomerService;
import ch.duc.northwind.spring.gwt.shared.dto.CustomerDTO;

public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private ch.duc.northwind.logic.CustomerService customerService;
	
	@Override
	public List<CustomerDTO> getCustomers(int firstResult, int maxResult) {
		List<Customer> custs = customerService.findCustomers(firstResult, maxResult);
		List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
		for (Customer c : custs) {
			customers.add(createCustomerDTO(c));
		}
		return customers;
	}

	@Override
	public long countCustomers() {
		return customerService.countCustomers();
	}

	
	private CustomerDTO createCustomerDTO(Customer customer) {
		CustomerDTO c = new CustomerDTO();
		c.setId(customer.getId());
		c.setAddress(customer.getAddress());
		c.setCity(customer.getCity());
		c.setCompanyName(customer.getCompanyName());
		c.setContactName(customer.getContactName());
		c.setContactTitle(customer.getContactTitle());
		c.setCountry(customer.getCountry());
		c.setFax(customer.getFax());
		c.setPhone(customer.getPhone());
		c.setPostalCode(customer.getPostalCode());
		c.setRegion(customer.getRegion());
		return c;
	}

}
