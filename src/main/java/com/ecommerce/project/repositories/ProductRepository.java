package com.ecommerce.project.repositories;

import com.ecommerce.project.model.Product;

import jakarta.transaction.Transactional;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Transactional
public class ProductRepository {


    public List<Product> findAll() {
        //todo need to update this for hibernate
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        return session.createQuery("from Product", Product.class).list();
        return null;
    }

    public void addProd(Product product) {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        session.save(product);
        return;
    }


    public void updateProd(Long id, Product product) {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        if (product != null) {
//            session.update(product);
//        }
    }

    public void deleteProd(Long id) {
//        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//        Product product = session.get(Product.class, id);
//        if (product != null) {
//            session.delete(product);
//        }
    }
}
