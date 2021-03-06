/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.randika.springMVC.controllers;

import com.randika.springMVC.domain.Product;
import com.randika.springMVC.services.ProductService;
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
    
    @RequestMapping("/product/{id}")
    public String getProduct(@PathVariable Integer id, Model model){
        
        model.addAttribute("product",productService.getProductById(id));
        
        return "product";
    }
    
    @RequestMapping("/product/new")
    public String newProduct(Model model){
    
        model.addAttribute("product", new Product());
        return "productForm";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(Product product){
        Product saveProduct = productService.saveOrUpdateProduct(product);
        return "redirect:/product/"+saveProduct.getId();
    }
    
    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Integer id,Model model){
        
        model.addAttribute("product", productService.getProductById(id));
        
        return "productForm";
    }
    
    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable Integer id){
        productService.deleteProduct(id);
        
        return "redirect:/products";
    }
    
}
