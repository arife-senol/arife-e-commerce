package com.arifesonol.backende_commerce.controller;

import com.arifesonol.backende_commerce.dto.RegisterRequest;
import com.arifesonol.backende_commerce.dto.RegisterResponse;
import com.arifesonol.backende_commerce.entity.user.User;
import com.arifesonol.backende_commerce.services.user.AuthenticationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
@AllArgsConstructor
@CrossOrigin("http://localhost:5173")
public class RegisterController {
    private AuthenticationService authenticationService;
    @PostMapping()
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
       User createdUser =  authenticationService
                .register(registerRequest.name(), registerRequest.email(), registerRequest.password(), registerRequest.role_id());
        return new RegisterResponse(createdUser.getEmail(), "New user created.");
    }
}
