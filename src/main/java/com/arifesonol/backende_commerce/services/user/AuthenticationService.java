package com.arifesonol.backende_commerce.services.user;


import com.arifesonol.backende_commerce.dto.LoginResponse;
import com.arifesonol.backende_commerce.entity.user.Role;
import com.arifesonol.backende_commerce.entity.user.User;
import com.arifesonol.backende_commerce.exceptions.EcommerceException;
import com.arifesonol.backende_commerce.repository.user.RoleRepository;
import com.arifesonol.backende_commerce.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthenticationService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public  User register(String fullName, String email, String password, Long roleId) {
        String encodedPassword = passwordEncoder.encode(password);
        Optional<Role> optionalRole = roleRepository.findById(roleId);

        Role userRole = new Role();
        if(optionalRole.isPresent()){
          //  userRole = roleRepository.findByCode(optionalRole.get().getCode()).orElseThrow();
            String roleCode = optionalRole.get().getCode();
            if (roleCode == null || roleCode.isEmpty()) {
                // Eğer kod null veya boşsa, roleId'ye göre set işlemi yapıyoruz
                userRole.setCode(roleId % 2 == 0 ? "A" : "U");
                userRole.setName(roleId % 2 == 0 ? "ADMIN" : "USER");
            } else {
                // Eğer kod null değilse, role'nin mevcut değerlerini alıyoruz
                userRole = roleRepository.findByCode(roleCode).orElseThrow();
            }
        }

        User user = new User();
        user.setName(fullName);
        user.setEmail(email);
        user.setPassword(encodedPassword);
        // userRole.setId(roleId);
         userRole.setCode(roleId%2==0 ? "A" : "U");
         userRole.setName(roleId %2==0 ? "ADMIN" : "USER");
        Set<Role> roles = new HashSet<>();  // Kullanıcının rolleri
        roles.add(userRole); // Rol setine kullanıcının rolü eklenir
        user.setRoles(roles); // Kullanıcının rolleri User nesnesine atanır

        return userRepository.save(user);
    }

    public LoginResponse authenticate(String email, String password) {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new EcommerceException("User not found", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(password, user.getPassword())) {
            Role userRole = user.getRoles().iterator().next();   // Kullanıcının rollerinden ilkini al
            return new LoginResponse(user.getEmail(), user.getName(), userRole.getId().toString());
        } else {
            throw new EcommerceException("Invalid email or password", HttpStatus.UNAUTHORIZED);
        }
    }

    public User verifyUser(String email) {
        return userRepository.findUserByEmail(email)
                .orElseThrow(() -> new EcommerceException("User not found", HttpStatus.NOT_FOUND));
    }
}