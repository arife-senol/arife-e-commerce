package com.arifesonol.backende_commerce.services;

import com.arifesonol.backende_commerce.dto.CategoryResponse;
import com.arifesonol.backende_commerce.entity.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();

    Category findById(Long id);
}
