package com.aakash.blog.controller;

import com.aakash.blog.domain.dtos.CategoryDto;
import com.aakash.blog.domain.dtos.CreateCategoryRequest;
import com.aakash.blog.domain.entities.Category;
import com.aakash.blog.mappers.CategoryMapper;
import com.aakash.blog.services.CategoryServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryServices categoryServices;
    private final CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> listCategories(){
        List<Category> categories = categoryServices.listCategories();
        return new ResponseEntity<>(categories.stream().map(categoryMapper::toDto).toList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CreateCategoryRequest createCategoryRequest){
       Category categoryToCreate =  categoryMapper.toEntity(createCategoryRequest);
       Category savedCategory = categoryServices.createCategory(categoryToCreate);
       return new ResponseEntity<>(categoryMapper.toDto(savedCategory),HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable UUID id){
        categoryServices.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
