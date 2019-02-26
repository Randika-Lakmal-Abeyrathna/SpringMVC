/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.randika.springMVC.services;

import com.randika.springMVC.domain.Customer;
import java.util.List;

/**
 *
 * @author randika-lakmal
 */
public interface CustomerService {
    
    List<Customer> listAllCustomers();
    
    Customer getCustomerByID(Integer id);
    
    Customer saveOrUpdateCustomer(Customer customer);
    
    void deleteCustomer(Integer id);
    
}
