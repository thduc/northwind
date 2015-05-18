package ch.duc.northwind.spring.gwt.client;

import ch.duc.northwind.spring.gwt.client.view.CustomersView;
import ch.duc.northwind.spring.gwt.client.view.HomeView;
import ch.duc.northwind.spring.gwt.client.view.impl.CustomersViewImpl;
import ch.duc.northwind.spring.gwt.client.view.impl.CustomersViewImpl2;
import ch.duc.northwind.spring.gwt.client.view.impl.HomeViewImpl;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class ClientFactoryImpl implements ClientFactory {
	
	private EventBus eventBus = null;
	private CustomerServiceAsync customerService = null;
	private HomeView homeView = null;
	private CustomersView customersView = null, customersView2 = null;

	@Override
	public EventBus getEventBus() {
		if (eventBus == null) {
			eventBus = new SimpleEventBus();
		}
		return eventBus;
	}

	@Override
	public CustomerServiceAsync getCustomersService() {
		if (customerService == null) {
			customerService = GWT.create(CustomerService.class);
		}
		return customerService;
	}

	@Override
	public HomeView getHomeView() {
		if (homeView == null) {
			homeView = new HomeViewImpl();
		}
		return homeView;
	}

	@Override
	public CustomersView getCustomersView() {
		if (customersView == null) {
			customersView = new CustomersViewImpl();
		}
		return customersView;
	}

	@Override
	public CustomersView getCustomersView2() {
		if (customersView2 == null) {
			customersView2 = new CustomersViewImpl2();
		}
		return customersView2;
	}

}
