package com.SagarDev.SpringWebApp.Controller;

import com.SagarDev.SpringWebApp.Model.Product;
import com.SagarDev.SpringWebApp.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @RequestMapping("/products")
    public List<Product> Product(){
        return service.getProducts();
    }

    // get products by id
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProductById(id);
    }

    // add a product in the array using POST method
    @PostMapping("/products")
    public String addProduct(@RequestBody Product product){
        service.addProduct(product);
        return "Product added successfully";
    }


    // update a product using Put method
    @PutMapping("/products")
    public String UpdateProduct(@RequestBody Product product){
        service.updateProduct(product);
        return "Product updated successfully";
    }

    //delete a product using delete method

    @DeleteMapping("/products/{id}")
    public String deleteProductById(@PathVariable int id){

        service.deleteProduct(id);
        return "Product deleted successfully";

    }







}
