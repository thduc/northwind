package ch.duc.northwind.bean;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.icefaces.ace.model.table.LazyDataModel;
import org.icefaces.ace.model.table.SortCriteria;

import ch.duc.northwind.domain.Customer;
import ch.duc.northwind.logic.CustomerService;

@Named
@RequestScoped
public class LazyCustomerBean {
	@Inject
	private CustomerService customerService;
	
	private LazyDataModel<Customer> customerModel;
	
	@PostConstruct
	public void init() {
		customerModel = new LazyCustomerDataModel(customerService);
	}
	
	public LazyDataModel<Customer> getCustomerModel() {
		return customerModel;
	}

    private static class LazyCustomerDataModel extends LazyDataModel<Customer> {

    	private static final long serialVersionUID = -4846387761900751796L;
    	
    	private CustomerService customerService;

		public LazyCustomerDataModel(CustomerService customerService) {
			super();
			this.customerService = customerService;
		}

		@Override
		public List<Customer> load(int first, int pageSize, SortCriteria[] sortCriteria, Map<String, String> filters) {
			List<Customer> customers = customerService.findCustomers(first, pageSize);
			setRowCount((int) customerService.countCustomers());
			return customers;
		}
    }
}
