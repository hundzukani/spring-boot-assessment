package com.rwa.assessment.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rwa.assessment.domain.Customer;
import com.rwa.assessment.service.CustomerService;

@Controller
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	
	 @GetMapping(value = "/customers")
	    public String list(Model model){
	        model.addAttribute("customers", customerService.listAllCustomers());
	        return "customers";
	    }

	    @GetMapping("customer/{id}")
	    public String showCustomer(@PathVariable Long id, Model model){
	        model.addAttribute("customer", customerService.getCustomerById(id));
	        return "customershow";
	    }

	    @GetMapping("customer/edit/{id}")
	    public String edit(@PathVariable Long id, Model model){
	        model.addAttribute("customer", customerService.getCustomerById(id));
	        return "customerform";
	    }

	    @GetMapping("customer/new")
	    public String newCustomer(Model model){
	        model.addAttribute("customer", new Customer());
	        return "customerform";
	    }

	    @PostMapping(value = "customer")
	    public String saveCustomer(Customer customer){
	    	if(null != customer && (null == customer.getCustomerId() || customer.getCustomerId().isEmpty())) {
	    		customer.setCustomerId(UUID.randomUUID().toString());
	    	}
	    	customerService.saveCustomer(customer);
	        return "redirect:/customer/" + customer.getId();
	    }

	    @GetMapping("customer/delete/{id}")
	    public String delete(@PathVariable Long id){
	    	customerService.deleteCustomer(id);
	        return "redirect:/customers";
	    }
	
	
}
