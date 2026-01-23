package com.ecommerce.project.repositories;

import com.ecommerce.project.model.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Product> findAll() {
        return entityManager
                .createQuery("SELECT p FROM Product p", Product.class)
                .getResultList();
    }

    public void addProd(Product product) {
        entityManager.persist(product);
    }

    public void updateProd(Long id, Product product) {
        Product existing = entityManager.find(Product.class, id);

        if (existing == null) {
            throw new EntityNotFoundException("Product not found with id " + id);
        }

        existing.setProductName(product.getProductName());
        existing.setQuantity(product.getQuantity());

    }

    public void deleteProd(Long id) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            entityManager.remove(product);
        }
    }
}
