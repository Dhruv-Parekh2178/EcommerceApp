package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;

import java.util.List;

public interface  CategoryService{
    List<Category> getAllCategories();
    Void CreateCategory(Category category);

    String deleteCategory(Long categoryId);

    Category UpdateCategoryById(Category category, Long categoryId);
}
