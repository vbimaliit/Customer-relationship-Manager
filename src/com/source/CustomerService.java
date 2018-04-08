package com.source;

import java.util.List;

import com.source.entity.Customer;

public interface CustomerService {

	
	public List<Customer> getCustomer();

	public void savecustomer(Customer thecustomer);

	public Customer getcustomerinfo(int id);

	public void deletecustomerinfo(int id);

	public List<Customer> getcustomerinfo(String customername);
}
