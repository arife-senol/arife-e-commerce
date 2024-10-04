package com.arifesonol.backende_commerce.services.user;

import com.arifesonol.backende_commerce.DtoConverter.user.UserConverter;
import com.arifesonol.backende_commerce.dto.RoleResponse;
import com.arifesonol.backende_commerce.repository.user.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    @Override
    public List<RoleResponse> getAll() {
        return UserConverter.convertToRoleResponseList(roleRepository.findAll());
    }
}
