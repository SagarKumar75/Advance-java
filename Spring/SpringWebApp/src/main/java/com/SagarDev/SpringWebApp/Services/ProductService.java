package com.SagarDev.SpringWebApp.Services;

import com.SagarDev.SpringWebApp.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class ProductService {

    List<Product> products= new ArrayList(Arrays.asList(new Product(1,"tv",5000),
            new Product(2,"freeze",9000)));
    public List<Product> getProducts(){

        return products;

    }

    public Product getProductById(int id) {
        int index=0;
        for(int i=0;i<products.size();i++){
            if(products.get(i).getId()==id){
                index=i;
                break;
            }
        }
        return products.get(index);

    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        int index=0;
        for(int i=0;i<products.size();i++){
            if(products.get(i).getId()==product.getId()){
                index=i;
                break;
            }
        }
        products.set(index,product);
    }

    public void deleteProduct(int id) {
        int index=0;
        for(int i=0;i<products.size();i++){
            if(products.get(i).getId()==id){
                index=i;
                break;
            }
        }
        products.remove(index);
    }
}
