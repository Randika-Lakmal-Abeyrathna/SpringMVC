/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.randika.springMVC.services;

import com.randika.springMVC.domain.Product;
import java.util.List;

/**
 *
 * @author randika-lakmal
 */
public interface ProductService {
    List<Product> listAllProducts(); 
    
    Product getProductById(Integer id);
    
    Product saveOrUpdateProduct(Product product);
    
    void deleteProduct(Integer id);
}
