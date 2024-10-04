package com.arifesonol.backende_commerce.repository.user;

import com.arifesonol.backende_commerce.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long>{
    @Query("SELECT r FROM Role r WHERE r.code = :code")
    Optional<Role> findByCode(String code);
}
