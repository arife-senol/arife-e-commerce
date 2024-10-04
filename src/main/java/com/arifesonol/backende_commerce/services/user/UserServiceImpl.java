package com.arifesonol.backende_commerce.services.user;

import com.arifesonol.backende_commerce.entity.user.User;
import com.arifesonol.backende_commerce.exceptions.EcommerceException;
import com.arifesonol.backende_commerce.repository.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElseThrow(() ->
                new EcommerceException("User is not found with id: " + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

}