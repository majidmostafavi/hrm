package com.noor.service;

import com.noor.dao.CategoryRepository;
import com.noor.entity.Category;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class CategoryService {
    @Inject
    CategoryRepository categoryRepository;


    public List<Category> findAllCategory() {
        return categoryRepository.listAll();
    }
}
