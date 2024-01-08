package com.dev.backend.service;

import com.dev.backend.entity.Category;
import com.dev.backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> searchAll(){
        return categoryRepository.findAll();
    }

    public Category insert(Category category){
        category.setDateCreation(new Date());
        Category newCategory = categoryRepository.saveAndFlush(category);
        return newCategory;
    }

    public Category modify(Category category){
        category.setDateUpdate(new Date());
        return categoryRepository.saveAndFlush(category);
    }

    public void delete(Long id){
        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
    }

}
