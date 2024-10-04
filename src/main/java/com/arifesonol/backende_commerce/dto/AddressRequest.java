package com.arifesonol.backende_commerce.dto;

public record AddressRequest(
        Long id,
        Long user_id,
        String name,
        String surname,
        String city,
        String district,
        String neighborhood,
        String address,
        String title,
        String phone
) {}
