package com.rwa.assessment.service;

import com.rwa.assessment.domain.Customer;

public interface CustomerService {

	Iterable<Customer> listAllCustomers();

	Customer getCustomerById(Long id);

	Customer saveCustomer(Customer customer);

    void deleteCustomer(Long id);
}
