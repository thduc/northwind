package ch.duc.northwind.controller.rest;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.duc.northwind.domain.Customer;
import ch.duc.northwind.logic.CustomerService;

@RestController
@RequestMapping(value="/rest/customers-datatables")
public class RestCustomerDatatableController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping
	public DatatablesCustomerResponse customers(
			@RequestParam Map<String,String> params
		) {
		System.out.println("----- Request parameters -----");
		for (Entry<String, String> param: params.entrySet()) {
			System.out.println(param.getKey() + ":" + param.getValue());
		}
		System.out.println("----- Request parameters -----");
		int draw = Integer.parseInt(params.get("draw"));
		int firstResult = Integer.parseInt(params.get("start")), maxResult = Integer.parseInt(params.get("length"));
		int recordsTotal = (int) customerService.countCustomers(), recordsFiltered = recordsTotal;
		List<Customer> data = customerService.findCustomers(firstResult, maxResult);
		String error = null;
		return new DatatablesCustomerResponse(draw, recordsTotal, recordsFiltered, data, error);
	}
}
