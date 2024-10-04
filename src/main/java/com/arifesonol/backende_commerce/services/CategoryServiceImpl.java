package com.arifesonol.backende_commerce.services;

import com.arifesonol.backende_commerce.DtoConverter.category.CategoryConverter;
import com.arifesonol.backende_commerce.dto.CategoryResponse;
import com.arifesonol.backende_commerce.entity.Category;
import com.arifesonol.backende_commerce.exceptions.EcommerceException;
import com.arifesonol.backende_commerce.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        return new CategoryConverter().toCategoryResponseListConverter(categories);
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.orElseThrow(() ->
                new EcommerceException("Category with given id is not exist: " + id, HttpStatus.NOT_FOUND));
    }
}
