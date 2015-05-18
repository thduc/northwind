package ch.duc.northwind.spring.gwt.client.presenter.impl;

import java.util.List;

import ch.duc.northwind.spring.gwt.client.ClientFactory;
import ch.duc.northwind.spring.gwt.client.CustomerServiceAsync;
import ch.duc.northwind.spring.gwt.client.presenter.CustomersPresenter;
import ch.duc.northwind.spring.gwt.client.view.CustomersView;
import ch.duc.northwind.spring.gwt.shared.dto.CustomerDTO;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.HasData;
import com.google.gwt.view.client.Range;

public class CustomersPresenterImpl extends BasicPresenterImpl implements CustomersPresenter {
	
	private CustomersView view;
	private CustomerServiceAsync customerService;
	
	public CustomersPresenterImpl(ClientFactory clientFactory) {
		super(clientFactory);
		customerService = clientFactory.getCustomersService();
		view = clientFactory.getCustomersView();
		view.setPresenter(this);
		customerService.countCustomers(new AsyncCallback<Long>() {
			@Override
			public void onSuccess(Long result) {
				view.setNumberOfCustomers(result);
			}
			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error counting number of customers");
			}
		});
	}

	@Override
	public void go(HasWidgets container) {
		container.clear();
		container.add(view.asWidget());
	}

	@Override
	public void onSelectCustomer(String customerId) {
	}

	@Override
	public AsyncDataProvider<CustomerDTO> getCustomersDataProvider() {
		return new AsyncDataProvider<CustomerDTO>() {
			@Override
			protected void onRangeChanged(HasData<CustomerDTO> display) {
		        Range range = display.getVisibleRange();
		        final int start = range.getStart();
		        int length = range.getLength();
		        customerService.getCustomers(start, length, new AsyncCallback<List<CustomerDTO>>() {
					@Override
					public void onSuccess(List<CustomerDTO> result) {
						updateRowData(start, result);
					}
					@Override
					public void onFailure(Throwable caught) {
						Window.alert("Error loading customers");
					}
				});
			}
		};
	}
}
