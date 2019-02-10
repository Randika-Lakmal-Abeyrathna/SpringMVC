/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.randika.springMVC.controllers;

import com.randika.springMVC.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author randika-lakmal
 */
@Controller
public class ProductController {
    
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    
    
    
    @RequestMapping("/products")
    public String listProducts(Model model){
        
       model.addAttribute("products",productService.listAllProducts());
        
        return "products";
    }
    
}
