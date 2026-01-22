package com.ecommerce.project.service;

import com.ecommerce.project.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    void addProduct(Product product);


    void updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}
