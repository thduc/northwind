package ch.duc.northwind.spring.gwt.client.view;

import ch.duc.northwind.spring.gwt.client.presenter.HomePresenter;

import com.google.gwt.user.client.ui.IsWidget;

public interface HomeView extends IsWidget {
	void setPresenter(HomePresenter presenter);
}
