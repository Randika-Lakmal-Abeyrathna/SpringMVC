/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.randika.springMVC.services;

import com.randika.springMVC.domain.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author randika-lakmal
 */
@Service
public class ProductServiceImpl  implements  ProductService{

    private Map<Integer,Product> products;
    
        public ProductServiceImpl(){
            loadProducts();
        }
    
    @Override
    public List<Product> listAllProducts() {
        return new ArrayList<>(products.values());
    
        
    }
    
        private void loadProducts(){
            products = new HashMap<>();
            
            Product product1 = new Product();
            product1.setId(1);
            product1.setDescription("Product 1");
            product1.setPrice(new BigDecimal("12.99"));
            product1.setImageUrl("http://example.com/product1");
            products.put(1,product1);
            
            Product product2 = new Product();
            product2.setId(2);
            product2.setDescription("Product 2");
            product2.setPrice(new BigDecimal("20.99"));
            product2.setImageUrl("http://example.com/product2");
            products.put(2,product2);
            
            Product product3 = new Product();
            product3.setId(3);
            product3.setDescription("Product 3");
            product3.setPrice(new BigDecimal("40.99"));
            product3.setImageUrl("http://example.com/product3");
            products.put(3,product3);
            
            Product product4 = new Product();
            product4.setId(4);
            product4.setDescription("Product 4");
            product4.setPrice(new BigDecimal("33.99"));
            product4.setImageUrl("http://example.com/product4");
            products.put(4,product4);
            
            Product product5 = new Product();
            product5.setId(5);
            product5.setDescription("Product 5");
            product5.setPrice(new BigDecimal("60.99"));
            product5.setImageUrl("http://example.com/product5");
            products.put(5,product5);
            
            
    }

    @Override
    public Product getProductById(Integer id) {

        return products.get(id);
    }
}
