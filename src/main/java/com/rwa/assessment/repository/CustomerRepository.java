package com.rwa.assessment.repository;

import org.springframework.data.repository.CrudRepository;

import com.rwa.assessment.domain.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
