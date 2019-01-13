package com.rwa.assessment.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rwa.assessment.configuration.RepositoryConfiguration;
import com.rwa.assessment.domain.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RepositoryConfiguration.class)
public class CustomerRepositoryTest {
	
	
	private CustomerRepository customerRepository;

	private Customer customer;
	
	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Before
	public void setUp() {
		customer = new Customer();
		customer.setAddress("Sandton");
		customer.setCustomerId(UUID.randomUUID().toString());
		customer.setEmail("hundzukani@gmail.com");
		customer.setFirstName("Hundzukani");
		customer.setLastName("Manganyi");
		
	}
	
    @Test
    public void testSaveCustomer(){
    	//Save customer, verify has ID value after save
        assertNull(customer.getId()); //null before save
        customerRepository.save(customer);
        assertNotNull(customer.getId()); //not null after save
        
        //Fetch customer from DB by Id
        Customer fetchedCustomer = customerRepository.findById(customer.getId()).orElseThrow(AssertionError::new);

        //Customer ID should be same as DB Customer ID
        assertEquals(customer.getId(), fetchedCustomer.getId());
    	
        // verify that the customer id is not null or empty
        assertNotNull(fetchedCustomer.getCustomerId());
    
        //verify count of customers in DB
        long customerCount = customerRepository.count();
        assertEquals(customerCount, 1);
        
        //get all customers, list should only have one entry
        Iterable<Customer> customers = customerRepository.findAll();
        int count = 0;

        for(Customer customer : customers){
            count++;
        }
        assertEquals(count, 1);
    }
    

}
