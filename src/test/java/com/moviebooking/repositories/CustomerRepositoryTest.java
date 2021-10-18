package com.moviebooking.repositories;

import java.util.HashMap;
import java.util.Map;

import com.moviebooking.entities.Customer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CustomerRepositoryTest")
public class CustomerRepositoryTest {
    private CustomerRepository customerRepository;

    @BeforeEach
    public void setUp(){
        Map<String,Customer> customerMap = new HashMap<>();
        customerMap.put("Cust1", new Customer("Cust1","Name1","cust1@gmail.com"));
        customerMap.put("Cust2", new Customer("Cust2","Name2","cust2@gmail.com"));
        customerMap.put("Cust3", new Customer("Cust3","Name3","cust3@gmail.com"));

        customerRepository = new CustomerRepository(customerMap);
    }

    @Test
    @DisplayName("getCustomerById_shouldReturnCustomer")
    public void getCustomerById_shouldReturnCustomer(){
        // Arrange
        Customer c1 = new Customer("Cust2","Name2","cust2@gmail.com");

        // Act
        Customer c2 = customerRepository.getCustomerById("Cust2");

        // Assert
        Assertions.assertEquals(c1, c2);
    }

    @Test
    @DisplayName("getCustomerById_shouldReturnNull")
    public void getCustomerById_shouldReturnNull(){
        Assertions.assertNull(customerRepository.getCustomerById("Cust4"));
    }

    @Test
    @DisplayName("saveCustomer_shouldSaveCustomer")
    public void saveCustomer_shouldSaveCustomer(){
        Customer c1 = new Customer("Cust5","Name5","cust5@gmail.com");
        customerRepository.saveCustomer(c1);
        Assertions.assertEquals(c1,customerRepository.getCustomerById("Cust5"));
    }
    
}