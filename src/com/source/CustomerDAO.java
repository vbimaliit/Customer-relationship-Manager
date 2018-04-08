package com.source;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.source.entity.Customer;


@Repository

public class CustomerDAO implements CustomerInfo {

	@Autowired
	 private SessionFactory sessionFactory; 
	
	
	
	@Override
	
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		
		System.out.println(sessionFactory);
	 Session session = sessionFactory.getCurrentSession();
	 
	 Query<Customer> query = session.createQuery("from Customer order by lastname",Customer.class);
	 
	 List<Customer> customers = query.getResultList();
	 System.out.println(customers.size());
	 
	 return customers;
		
	}

	@Override

	public void savecustomer(Customer thecustomer) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		System.out.println(thecustomer);
		session.saveOrUpdate(thecustomer);
	}

	@Override
	public Customer getcustomerinfo(int id) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		Customer cust = session.get(Customer.class, id);
		
		return cust;
	}

	@Override
	public void deletecustomer(int id) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("delete from Customer where id=:thecustomerid");
		
		query.setParameter("thecustomerid", id);
		
		query.executeUpdate();
		
	}

	@Override
	public List<Customer> searchcustomer(String customername) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.getCurrentSession();
		
		Query <Customer> query = session.createQuery("from Customer where lower(firstname) like:thename or lower(lastname) like:thename",Customer.class);
		
		query.setParameter("thename",customername);
		
		
		
		List<Customer> custo = query.getResultList();
		
		return custo;
	}

}
