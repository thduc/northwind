package ch.duc.northwind.bean;

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
		return customerService.findCustomers(0, -1);
	}
}
