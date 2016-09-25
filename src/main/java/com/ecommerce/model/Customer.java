package com.ecommerce.model;

public class Customer {
	private String customerId;
	private String customerName;
	private String customerEmail;
	private String customerAddress;
	
	private Transaction trasaction;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Transaction getTrasaction() {
		return trasaction;
	}

	public void setTrasaction(Transaction trasaction) {
		this.trasaction = trasaction;
	}
	
	
}
