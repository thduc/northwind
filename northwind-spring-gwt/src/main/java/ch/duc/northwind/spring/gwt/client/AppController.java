package ch.duc.northwind.spring.gwt.client;

import ch.duc.northwind.spring.gwt.client.presenter.Presenter;
import ch.duc.northwind.spring.gwt.client.presenter.impl.CustomersPresenterImpl;
import ch.duc.northwind.spring.gwt.client.presenter.impl.CustomersPresenterImpl2;
import ch.duc.northwind.spring.gwt.client.presenter.impl.HomePresenterImpl;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.SimplePanel;

public class AppController implements ValueChangeHandler<String>, Presenter {
	
	private ClientFactory clientFactory;
	private HasWidgets topLevelView;
	private DockLayoutPanel mainView;
	private SimplePanel contentView;
	
	public AppController(ClientFactory clientFactory) {
		super();
		this.clientFactory = clientFactory;
		bind();
	}

	private void bind() {
		History.addValueChangeHandler(this);
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		Presenter presenter = null;
		String token = event.getValue();
		if (token != null) {
			if (Tokens.Home.equals(token)) {
				presenter = new HomePresenterImpl(clientFactory);
			}
			else if (Tokens.Customers.equals(token)) {
				presenter = new CustomersPresenterImpl(clientFactory);
			}
			else if (Tokens.Customers2.equals(token)) {
				presenter = new CustomersPresenterImpl2(clientFactory);
			}
		}
		if (presenter == null) {
			presenter = new HomePresenterImpl(clientFactory);
		}
		presenter.go(contentView);
	}

	@Override
	public void go(HasWidgets container) {
		topLevelView = container;
		initView();
		History.newItem(Tokens.Home);
	}
	
	private void initView() {
		mainView = new DockLayoutPanel(Unit.EM);
		topLevelView.add(mainView);
		mainView.setSize("100%", "100%");
		
		// header
		FlowPanel header = new FlowPanel();
		mainView.addNorth(header, 2);
		Button home = new Button("Home");
		header.add(home);
		home.addClickHandler(new ButtonHistoryHandler(Tokens.Home));
		Button customers = new Button("Customers");
		header.add(customers);
		customers.addClickHandler(new ButtonHistoryHandler(Tokens.Customers));
		Button customers2 = new Button("Customers Datagrid");
		header.add(customers2);
		customers2.addClickHandler(new ButtonHistoryHandler(Tokens.Customers2));
		// footer
		mainView.addSouth(new HTML("footer"), 2);
		// content
		contentView = new SimplePanel();
		mainView.add(contentView);
	}

	private static class ButtonHistoryHandler implements ClickHandler {
		private String token;
		
		ButtonHistoryHandler(String token) {
			this.token = token;
		}
		
		@Override
		public void onClick(ClickEvent event) {
			History.newItem(token);
		}
		
	}
}
