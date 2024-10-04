package com.arifesonol.backende_commerce.services;

import com.arifesonol.backende_commerce.dto.ProductResponse;
import com.arifesonol.backende_commerce.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();

    Product findById(Long id);
}
