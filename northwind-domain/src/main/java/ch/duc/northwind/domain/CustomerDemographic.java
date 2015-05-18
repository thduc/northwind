package ch.duc.northwind.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the customerdemographics database table.
 * 
 */
@Entity
@Table(name="customerdemographics")
@NamedQuery(name="CustomerDemographic.findAll", query="SELECT c FROM CustomerDemographic c")
@JsonIgnoreProperties(value={"customers"})
public class CustomerDemographic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String customerTypeId;

	@Column(name="customerdesc")
	private String customerDescription;

	//bi-directional many-to-many association to Customer
	@ManyToMany(mappedBy="customerDemographics")
	private List<Customer> customers;

	public CustomerDemographic() {
	}

	public String getCustomerTypeId() {
		return this.customerTypeId;
	}

	public void setCustomerTypeId(String customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	public String getCustomerDescription() {
		return this.customerDescription;
	}

	public void setCustomerDescription(String customerDescription) {
		this.customerDescription = customerDescription;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

}