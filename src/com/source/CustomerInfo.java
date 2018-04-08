package com.source;

import java.util.List;

import com.source.entity.Customer;

public interface CustomerInfo {
	
	public List<Customer> getCustomer();

	public void savecustomer(Customer thecustomer);

	public Customer getcustomerinfo(int id);

	public void deletecustomer(int id);

	public List<Customer> searchcustomer(String customername);

}
