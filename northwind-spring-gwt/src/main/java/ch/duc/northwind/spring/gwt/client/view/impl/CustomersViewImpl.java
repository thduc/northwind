package ch.duc.northwind.spring.gwt.client.view.impl;

import ch.duc.northwind.spring.gwt.shared.dto.CustomerDTO;

import com.google.gwt.user.cellview.client.AbstractCellTable;
import com.google.gwt.user.cellview.client.CellTable;

public class CustomersViewImpl extends AbstractCustomersViewImpl {

	public CustomersViewImpl() {
		super();
	}

	@Override
	protected AbstractCellTable<CustomerDTO> createCustomersTable() {
		return new CellTable<CustomerDTO>();
	}

}
