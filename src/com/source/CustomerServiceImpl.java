package com.source;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.source.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerInfo customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		return customerDAO.getCustomer();
	}

	@Override
	@Transactional
	public void savecustomer(Customer thecustomer) {
		// TODO Auto-generated method stub
		
		customerDAO.savecustomer(thecustomer);
		
	}

	@Override
	@Transactional
	public Customer getcustomerinfo(int id) {
		// TODO Auto-generated method stub
		
		Customer cust = customerDAO.getcustomerinfo(id);
		return cust;
	}

	@Override
	@Transactional
	public void deletecustomerinfo(int id) {
		// TODO Auto-generated method stub
		
		customerDAO.deletecustomer(id);
	}

	@Override
	@Transactional
	public List<Customer> getcustomerinfo(String customername) {
		// TODO Auto-generated method stub
		
		List<Customer> custlist = customerDAO.searchcustomer(customername);
		return custlist;
	}
	
	

}
