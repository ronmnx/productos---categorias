package com.ronaldo.productos_y_categorias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ronaldo.productos_y_categorias.models.Category;
import com.ronaldo.productos_y_categorias.repositories.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> opCategory = categoryRepository.findById(id);
        return opCategory == null ? null : opCategory.get();
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
