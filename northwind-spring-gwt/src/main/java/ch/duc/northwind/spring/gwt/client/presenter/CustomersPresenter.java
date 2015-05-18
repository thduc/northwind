package ch.duc.northwind.spring.gwt.client.presenter;

import ch.duc.northwind.spring.gwt.shared.dto.CustomerDTO;

import com.google.gwt.view.client.AsyncDataProvider;

public interface CustomersPresenter extends Presenter {
	void onSelectCustomer(String customerId);
	AsyncDataProvider<CustomerDTO> getCustomersDataProvider();
}
