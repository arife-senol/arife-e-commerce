package com.arifesonol.backende_commerce.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private Instant timestamp;
}