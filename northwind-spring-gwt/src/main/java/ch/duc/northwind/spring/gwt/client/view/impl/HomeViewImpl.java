package ch.duc.northwind.spring.gwt.client.view.impl;

import ch.duc.northwind.spring.gwt.client.presenter.HomePresenter;
import ch.duc.northwind.spring.gwt.client.view.HomeView;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;

public class HomeViewImpl extends Composite implements HomeView {

	public HomeViewImpl() {
		DockLayoutPanel panel = new DockLayoutPanel(Unit.EM);
		panel.setSize("100%", "100%");
		initWidget(panel);
		panel.add(new HTML("Go home!"));
	}

	@Override
	public void setPresenter(HomePresenter presenter) {
	}

}
