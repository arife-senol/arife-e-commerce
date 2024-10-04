package com.arifesonol.backende_commerce.repository;

import com.arifesonol.backende_commerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
