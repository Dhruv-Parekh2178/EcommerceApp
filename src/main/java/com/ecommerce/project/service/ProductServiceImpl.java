package com.ecommerce.project.service;

import com.ecommerce.project.model.Product;
import com.ecommerce.project.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productRepository.addProd(product);
    }

    @Override
    public void updateProduct(Long id, Product product) {
        productRepository.updateProd(id, product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteProd(id);
    }
}
