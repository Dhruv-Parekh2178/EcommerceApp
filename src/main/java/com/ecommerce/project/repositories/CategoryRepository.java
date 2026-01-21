package com.ecommerce.project.repositories;

import com.ecommerce.project.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CategoryRepository extends JpaRepository<Category , Long>{

    @Query(value = "select * from  product",nativeQuery = true)
    int findAllByCategoryId(Long categoryId);
}
