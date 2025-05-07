package com.aakash.blog.services.impl;

import com.aakash.blog.domain.entities.Category;
import com.aakash.blog.repository.CategoryRepository;
import com.aakash.blog.services.CategoryServices;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryServices {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> listCategories() {
        return categoryRepository.findAllWithPostCount();
    }

    @Override
    @Transactional
    public Category createCategory(Category category) {
        if(categoryRepository.existsByNameIgnoreCase(category.getName())){
            throw new IllegalArgumentException("Category Already exists with name : "+category.getName());
        }
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(UUID id) {
       Optional<Category> category =  categoryRepository.findById(id);

       if(category.isPresent()){
           if(!category.get().getPosts().isEmpty()){
               throw new IllegalStateException("Category has posts associated with it");
           }

           categoryRepository.deleteById(id);
       }
    }

    @Override
    public Category getCategoryById(UUID id) {
        if (id == null) {
            throw new IllegalArgumentException("Category ID cannot be null");
        }
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id" + id));
    }
}
