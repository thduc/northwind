package ch.duc.northwind.spring.gwt.client;

import ch.duc.northwind.spring.gwt.client.view.CustomersView;
import ch.duc.northwind.spring.gwt.client.view.HomeView;

import com.google.web.bindery.event.shared.EventBus;

public interface ClientFactory {
	EventBus getEventBus();
	CustomerServiceAsync getCustomersService();
	HomeView getHomeView();
	CustomersView getCustomersView();
	CustomersView getCustomersView2();
}
