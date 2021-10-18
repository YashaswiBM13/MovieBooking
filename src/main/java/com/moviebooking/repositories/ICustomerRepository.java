package com.moviebooking.repositories;

import com.moviebooking.entities.Customer;

public interface ICustomerRepository {
    public Customer getCustomerById(String id);
    public void saveCustomer(Customer customer);
    
}