package ch.duc.northwind.spring.gwt.client.view;

import ch.duc.northwind.spring.gwt.client.presenter.CustomersPresenter;

import com.google.gwt.user.client.ui.IsWidget;

public interface CustomersView extends IsWidget {
	void setPresenter(CustomersPresenter presenter);
	void setNumberOfCustomers(long ncustomers);
}
