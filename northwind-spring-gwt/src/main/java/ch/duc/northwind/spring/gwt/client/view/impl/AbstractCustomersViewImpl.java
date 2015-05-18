package ch.duc.northwind.spring.gwt.client.view.impl;

import ch.duc.northwind.spring.gwt.client.presenter.CustomersPresenter;
import ch.duc.northwind.spring.gwt.client.view.CustomersView;
import ch.duc.northwind.spring.gwt.shared.dto.CustomerDTO;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.cellview.client.AbstractCellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.view.client.Range;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

abstract class AbstractCustomersViewImpl extends Composite implements CustomersView {
	
	protected CustomersPresenter presenter;
	protected SimplePager pager;
	protected AbstractCellTable<CustomerDTO> customersList;

	AbstractCustomersViewImpl() {
		DockLayoutPanel panel = new DockLayoutPanel(Unit.EM);
		panel.setSize("100%", "100%");
		initWidget(panel);
		customersList = createCustomersTable();
		customersList.setWidth("100%");
		bindCustomersListTable(customersList);
		addSelectionAction();
	    // Create paging controls.
	    pager = new SimplePager(TextLocation.CENTER, true, 60, true);
	    pager.setDisplay(customersList);
	    panel.addNorth(pager, 2);
		panel.add(customersList);
		customersList.setVisibleRangeAndClearData(new Range(0, 20), true);
	}
	
	protected abstract AbstractCellTable<CustomerDTO> createCustomersTable();

	protected void bindCustomersListTable(AbstractCellTable<CustomerDTO> table) {
		table.addColumn(new TextColumn<CustomerDTO>() {
			@Override
			public String getValue(CustomerDTO object) {
				return object.getId();
			}
		}, "Id");
		table.addColumn(new TextColumn<CustomerDTO>() {
			@Override
			public String getValue(CustomerDTO object) {
				return object.getCompanyName();
			}
		}, "Company name");
		table.addColumn(new TextColumn<CustomerDTO>() {
			@Override
			public String getValue(CustomerDTO object) {
				return object.getContactName();
			}
		}, "Contact name");
		table.addColumn(new TextColumn<CustomerDTO>() {
			@Override
			public String getValue(CustomerDTO object) {
				return object.getContactTitle();
			}
		}, "Contact title");
		table.addColumn(new TextColumn<CustomerDTO>() {
			@Override
			public String getValue(CustomerDTO object) {
				return object.getAddress();
			}
		}, "Address");
		table.addColumn(new TextColumn<CustomerDTO>() {
			@Override
			public String getValue(CustomerDTO object) {
				return object.getCity();
			}
		}, "City");
		table.addColumn(new TextColumn<CustomerDTO>() {
			@Override
			public String getValue(CustomerDTO object) {
				return object.getRegion();
			}
		}, "Region");
		table.addColumn(new TextColumn<CustomerDTO>() {
			@Override
			public String getValue(CustomerDTO object) {
				return object.getPostalCode();
			}
		}, "Postal code");
		table.addColumn(new TextColumn<CustomerDTO>() {
			@Override
			public String getValue(CustomerDTO object) {
				return object.getCountry();
			}
		}, "Country");
		table.addColumn(new TextColumn<CustomerDTO>() {
			@Override
			public String getValue(CustomerDTO object) {
				return object.getPhone();
			}
		}, "Phone");
		table.addColumn(new TextColumn<CustomerDTO>() {
			@Override
			public String getValue(CustomerDTO object) {
				return object.getFax();
			}
		}, "Fax");
	}
	
	protected void addSelectionAction() {
		customersList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		final SingleSelectionModel<CustomerDTO> selectionModel = new SingleSelectionModel<CustomerDTO>();
		customersList.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				CustomerDTO selected = selectionModel.getSelectedObject();
//				if (selected != null) {
//					Window.alert("Selected customer: " + selected.getCompanyName());
//				}
//				else {
//					Window.alert("No customer selected");
//				}
			}
		});
	}

	@Override
	public void setPresenter(CustomersPresenter presenter) {
		this.presenter = presenter;
		this.presenter.getCustomersDataProvider().addDataDisplay(customersList);
	}

	@Override
	public void setNumberOfCustomers(long ncustomers) {
		customersList.setRowCount((int) ncustomers);
	}
}
