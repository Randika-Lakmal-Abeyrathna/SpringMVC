/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.randika.springMVC.services;

import com.randika.springMVC.domain.Customer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author randika-lakmal
 */

@Service
public class CustomerServiceImpl implements CustomerService{

    private Map<Integer,Customer> customers;
    
    public CustomerServiceImpl(){
    loadCustomers();
    }
    
    @Override
    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customers.values());
    }
    
    private void loadCustomers(){
        customers = new HashMap<>();
        
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setFirstName("Randika");
        customer1.setLastName("Lakmal");
        customer1.setEmail("randika.help@gmail.com");
        customer1.setPhoneNumber("071159674");
        customer1.setAddressLineOne("Mandandawela");
        customer1.setAddressLineTwo("Jambugahapitiya");
        customer1.setCity("kandy");
        customer1.setState("Central");
        customer1.setZipCode("20822");
        
        customers.put(1, customer1);
        
        
    }

    @Override
    public Customer getCustomerByID(Integer id) {
        return customers.get(id);
    }

    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        
        if (customer !=null) {
            if (customer.getId() == null) {
                customer.setId(getNextKey());;
            }
            customers.put(customer.getId(), customer);
            return customer;
        }else{
            throw new RuntimeException("Customer can't be Null");
        }
        
    }
    
    private Integer getNextKey(){
        return Collections.max(customers.keySet())+1;
    }

    @Override
    public void deleteCustomer(Integer id) {
    
        customers.remove(id);
        
    }
    
}
