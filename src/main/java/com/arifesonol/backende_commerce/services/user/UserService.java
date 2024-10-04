package com.arifesonol.backende_commerce.services.user;

import com.arifesonol.backende_commerce.entity.user.User;

public interface UserService {
    User findById(Long id);
    User save(User user);

}
