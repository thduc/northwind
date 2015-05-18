package ch.duc.northwind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ch.duc.northwind.domain.Customer;
import ch.duc.northwind.logic.CustomerService;

@Controller
@RequestMapping(value="/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method=RequestMethod.GET)
	public List<Customer> customers(
			@RequestParam(value="firstResult", defaultValue="0") int firstResult,
			@RequestParam(value="maxResult", defaultValue="-1") int maxResult
		) {
		return customerService.findCustomers(firstResult, maxResult);
	}
}
