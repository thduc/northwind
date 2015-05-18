package ch.duc.northwind.spring.gwt.client.view.impl;

import ch.duc.northwind.spring.gwt.shared.dto.CustomerDTO;

import com.google.gwt.user.cellview.client.AbstractCellTable;
import com.google.gwt.user.cellview.client.DataGrid;

public class CustomersViewImpl2 extends AbstractCustomersViewImpl {

	public CustomersViewImpl2() {
		super();
	}

	@Override
	protected AbstractCellTable<CustomerDTO> createCustomersTable() {
		return new DataGrid<CustomerDTO>();
	}

}
