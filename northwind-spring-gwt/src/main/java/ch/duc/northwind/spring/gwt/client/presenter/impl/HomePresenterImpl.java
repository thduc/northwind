package ch.duc.northwind.spring.gwt.client.presenter.impl;

import ch.duc.northwind.spring.gwt.client.ClientFactory;
import ch.duc.northwind.spring.gwt.client.presenter.HomePresenter;
import ch.duc.northwind.spring.gwt.client.view.HomeView;

import com.google.gwt.user.client.ui.HasWidgets;

public class HomePresenterImpl extends BasicPresenterImpl implements HomePresenter {

	public HomePresenterImpl(ClientFactory clientFactory) {
		super(clientFactory);
	}

	@Override
	public void go(HasWidgets container) {
		HomeView view = clientFactory.getHomeView();
		view.setPresenter(this);
		container.clear();
		container.add(view.asWidget());
	}

}
