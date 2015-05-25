package ch.duc.northwind.portlet.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ch.duc.northwind.domain.Customer;
import ch.duc.northwind.logic.CustomerService;

@Named
@RequestScoped
public class CustomerBean {
	
	@Inject
	private CustomerService customerService;
	
	private List<Customer> customers;
	
	@PostConstruct
	public void init() {
/*
		// http://stackoverflow.com/questions/15502280/get-list-of-all-managed-beans-in-jsf-at-runtime
		ApplicationAssociate application = ApplicationAssociate.getInstance(FacesContext.getCurrentInstance().getExternalContext());
		BeanManager beanManager = application.getBeanManager();
		Map<String, BeanBuilder> beanMap = beanManager.getRegisteredBeans();
		Set<Entry<String, BeanBuilder>> beanEntries = beanMap.entrySet();
		for (Entry<String, BeanBuilder> bean : beanEntries) {
			String beanName = bean.getKey();
			if (beanManager.isManaged(beanName)) {
				BeanBuilder builder = bean.getValue();
				System.out.println("Bean name: " + beanName);
				System.out.println("Bean class: " + builder.getBeanClass());
				System.out.println("Bean scope: " + builder.getScope());
			}
		}
*/
	}
	
	public List<Customer> getCustomers() {
		if (customers == null) {
			loadCustomers();
		}
		return customers;
	}
	
	
	// http://stackoverflow.com/questions/2786834/between-a-jsf-page-and-a-managed-bean-why-the-getter-method-is-called-twice
	// http://stackoverflow.com/questions/2090033/why-jsf-calls-getters-multiple-times
	// http://stackoverflow.com/questions/4281261/why-is-the-getter-called-so-many-times-by-the-rendered-attribute
	// http://balusc.blogspot.ch/2006/09/debug-jsf-lifecycle.html
	private void loadCustomers() {
		customers = customerService.findCustomers(0, -1);
	}
}
