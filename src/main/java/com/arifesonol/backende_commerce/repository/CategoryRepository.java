package com.arifesonol.backende_commerce.repository;

import com.arifesonol.backende_commerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
