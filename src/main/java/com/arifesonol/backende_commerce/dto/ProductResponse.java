package com.arifesonol.backende_commerce.dto;

public record ProductResponse(Long id, String name, String description, Double rating, Integer stock, Integer sellCount, String image,
                              Long category_id, Double price) {
}
