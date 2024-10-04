package com.arifesonol.backende_commerce.controller;

import com.arifesonol.backende_commerce.DtoConverter.product.ProductConverter;
import com.arifesonol.backende_commerce.dto.ProductResponse;
import com.arifesonol.backende_commerce.entity.Product;
import com.arifesonol.backende_commerce.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@CrossOrigin("http://localhost:5173")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        Product product = productService.findById(id);
        ProductResponse productResponse = ProductConverter.toProductResponseConverter(product);
        return ResponseEntity.ok(productResponse);
    }
}
