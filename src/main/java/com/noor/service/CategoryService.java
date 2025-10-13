package com.noor.service;

import com.noor.dao.CategoryRepository;
import com.noor.entity.Category;
import com.noor.entity.Service;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class CategoryService {
    @Inject
    CategoryRepository categoryRepository;


    public List<Category> findAllCategory() {
        return categoryRepository.listAll();
    }


    public Optional<Category> findByIdOptional(Long id) {
        return categoryRepository.findByIdOptional(id);

    }

    @Transactional
    public Category create(Category category) {
        categoryRepository.persist(category);
        return category;

    }

    @Transactional
    public boolean update(Category category) {
        try {
            categoryRepository.getEntityManager().merge(category);
            return true;
        }  catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Transactional
    public boolean deleteById(Long id) {
        return categoryRepository.deleteById(id);

    }
}
