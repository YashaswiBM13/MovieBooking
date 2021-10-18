package com.moviebooking.repositories.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.moviebooking.entities.Customer;
import com.moviebooking.repositories.ICustomerRepository;

public class CustomerData implements IData{

    private final ICustomerRepository iCustomerRepository;

    public CustomerData(ICustomerRepository iCustomerRepository){
        this.iCustomerRepository = iCustomerRepository;
    }

    @Override
    public void load(String dataPath, String delimiter) {
        BufferedReader reader;
        try{
            String line = "";
            reader = new BufferedReader(new FileReader(dataPath));
            while((line = reader.readLine()) != null){
                List<String> tokens = Arrays.asList(line.split(delimiter));
                addCustomer(tokens.get(0), tokens.get(1), tokens.get(2));
            }
            reader.close();

        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    public void addCustomer(String id, String name, String email){
        iCustomerRepository.saveCustomer(new Customer(id, name, email));
    }
    
}