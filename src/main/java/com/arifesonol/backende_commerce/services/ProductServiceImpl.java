package com.arifesonol.backende_commerce.services;

import com.arifesonol.backende_commerce.DtoConverter.product.ProductConverter;
import com.arifesonol.backende_commerce.dto.ProductResponse;
import com.arifesonol.backende_commerce.entity.Product;
import com.arifesonol.backende_commerce.exceptions.EcommerceException;
import com.arifesonol.backende_commerce.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;


    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return ProductConverter.toProductResponseList(products);
    }

    @Override
    public Product findById(Long id) {
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.orElseThrow(() ->
                new EcommerceException("Product with given id is not exist: " + id, HttpStatus.NOT_FOUND));
    }
}
