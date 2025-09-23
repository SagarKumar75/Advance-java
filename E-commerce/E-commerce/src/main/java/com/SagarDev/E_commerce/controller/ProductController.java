package com.SagarDev.E_commerce.controller;

import com.SagarDev.E_commerce.model.Product;
import com.SagarDev.E_commerce.service.ProductService;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {
    @Autowired
    ProductService service;

    @RequestMapping("/")
    public String Home(){
        return "hello world";
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable int id){
        return service.getProductById(id);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product p){
        service.addProduct(p);
    }

    @PutMapping("/products/{id}")
    public void updateProduct(@RequestBody Product p,@PathVariable int id){
        p.setId((long)id);
        service.updateProduct(p);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id){
        service.deleteProduct(id);

    }


    @GetMapping("/products/search")
    public List<Product> searchProduct(@RequestParam String keyword){
        return service.searchProducts(keyword);
    }
}
