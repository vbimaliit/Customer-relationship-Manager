package com.source;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.source.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerser; 
	
	@GetMapping("/list")
	public String customerlist(Model themodel)
	{
		
	List<Customer> custo = customerser.getCustomer();
	
	//for(Customer cust : custo)
	//		System.out.println(cust);
	
	themodel.addAttribute("customers", custo);
	return "list";
	
		
	}
	
	@GetMapping("/showaddform")
	public String addform(Model themodel)
	{
		Customer custo = new Customer();
		
		themodel.addAttribute("customer1",custo);
		
		
		return "customer-add";
	}
	
	@PostMapping("/addcustomer")
	public String addcustomer(@ModelAttribute("customer1") Customer thecustomer)
	{
		customerser.savecustomer(thecustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showupdateform")
	public String showcustomerinfo(@RequestParam("customerid") int id,Model themodel)
	{
		Customer cust = customerser.getcustomerinfo(id);
		
		themodel.addAttribute("customer1",cust);
		
		return "customer-add";
		
		
		
	}
	
	@GetMapping("/delete")
	public String deletecustomer(@RequestParam("customerid") int id)
	{
		 customerser.deletecustomerinfo(id);
		 
		 return "redirect:/customer/list";
	}
	
	@PostMapping("/searchcustomer")
	public String searchcustomer(@RequestParam("customername") String customername , Model themodel)
	{
		
		List<Customer> custo = customerser.getcustomerinfo(customername);
		
		themodel.addAttribute("customers",custo);
		
		return "list";
	}

}
