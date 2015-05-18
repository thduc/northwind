package ch.duc.northwind.spring.gwt.client;

import java.util.List;

import ch.duc.northwind.spring.gwt.shared.dto.CustomerDTO;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("rpc/gwtCustomerService")
public interface CustomerService extends RemoteService {
	List<CustomerDTO> getCustomers(int firstResult, int maxResult);
	long countCustomers();
}
