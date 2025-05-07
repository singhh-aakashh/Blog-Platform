package com.aakash.blog.services;

import com.aakash.blog.domain.entities.Category;

import java.util.List;
import java.util.UUID;

public interface CategoryServices {
    List<Category> listCategories();

    Category createCategory(Category category);

    void deleteCategory(UUID id);
    Category getCategoryById(UUID id);
}
