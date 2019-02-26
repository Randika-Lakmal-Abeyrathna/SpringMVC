/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.randika.springMVC.controllers;

import com.randika.springMVC.domain.Customer;
import com.randika.springMVC.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author randika-lakmal
 */
@Controller
public class CustomerController {
    
    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }
    
    
    
    
    @RequestMapping("/customers")
    public String listCustomers(Model model){
        
        model.addAttribute("customers", customerService.listAllCustomers());
        
        return "customers";
    }
    
    @RequestMapping("/customer/{id}")
    public String getCustomer(@PathVariable Integer id,Model model){
        
        model.addAttribute("customer",customerService.getCustomerByID(id));
        
        return "customer";
    }
    
    @RequestMapping("/customer/new")
    public String newCustomer(Model model){
        model.addAttribute("customer", new Customer());
        return "customerForm";
    }
    
    @RequestMapping(value = "/customer",method = RequestMethod.POST)
    public String saveOrUpdateCustomer(Customer customer){
        
        Customer saveCustomer = customerService.saveOrUpdateCustomer(customer);
        
        return "redirect:/customer/"+saveCustomer.getId();
    }
    
    @RequestMapping("customer/edit/{id}")
    public String edit(@PathVariable Integer id,Model model){
        model.addAttribute("customer", customerService.getCustomerByID(id));
        return "customerForm";
    }
    
    @RequestMapping("customer/delete/{id}")
    public String delete(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }
    
}
