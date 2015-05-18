package ch.duc.northwind.spring.gwt.client.presenter.impl;

import ch.duc.northwind.spring.gwt.client.ClientFactory;
import ch.duc.northwind.spring.gwt.client.presenter.Presenter;

public abstract class BasicPresenterImpl implements Presenter {
	protected ClientFactory clientFactory;

	protected BasicPresenterImpl(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
	}
	
}
