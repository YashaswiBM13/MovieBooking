package com.moviebooking.repositories;

import java.util.HashMap;
import java.util.Map;

import com.moviebooking.entities.Customer;

public class CustomerRepository implements ICustomerRepository {

    private final Map<String,Customer> customerMap;

    public CustomerRepository(){
        customerMap = new HashMap<>();
    }
    public CustomerRepository(Map<String, Customer> customerMap){
        this.customerMap = customerMap;
    }

    
    @Override
    public Customer getCustomerById(String id) {
        return customerMap.get(id);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerMap.put(customer.getId(), customer);
    }
    
}