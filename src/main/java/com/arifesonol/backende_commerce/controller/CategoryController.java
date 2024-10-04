package com.arifesonol.backende_commerce.controller;


import com.arifesonol.backende_commerce.dto.CategoryResponse;
import com.arifesonol.backende_commerce.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
@CrossOrigin("http://localhost:5173")
public class CategoryController {
    private CategoryService categoryService;
    @GetMapping
    public List<CategoryResponse> getAll() {

        return categoryService.getAllCategories();
    }

}
