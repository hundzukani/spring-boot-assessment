package com.rwa.assessment.bootstrap;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.rwa.assessment.domain.Customer;
import com.rwa.assessment.repository.CustomerRepository;

@Component
public class CustomerLoader implements ApplicationListener<ContextRefreshedEvent> {

	   private static final Logger LOG = LoggerFactory.getLogger(CustomerLoader.class);
	
	private CustomerRepository customerRepository;

	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	 @Override
	 public void onApplicationEvent(ContextRefreshedEvent event) {
	
		 Customer custHund = new Customer();
		 custHund.setAddress("Ruimsug");
		 custHund.setCustomerId(UUID.randomUUID().toString());
		 custHund.setEmail("hundzukani@gmail.com");
		 custHund.setFirstName("Hundzukani");
		 custHund.setLastName("Manganyi");
		 
		 customerRepository.save(custHund);
	     LOG.info("Saved Customer - id {}", custHund.getId());
	     
	     Customer custNikkel = new Customer();
	     custNikkel.setAddress("Sandton");
	     custNikkel.setCustomerId(UUID.randomUUID().toString());
	     custNikkel.setEmail("nikkel@gmail.com");
	     custNikkel.setFirstName("Nikkel");
	     custNikkel.setLastName("Manganyi");
		 
	     customerRepository.save(custNikkel);
	     LOG.info("Saved Customer - id {}", custNikkel.getId());
	 }
	
	
}
