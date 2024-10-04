package com.arifesonol.backende_commerce.DtoConverter.user;

import com.arifesonol.backende_commerce.dto.LoginResponse;
import com.arifesonol.backende_commerce.dto.RoleResponse;
import com.arifesonol.backende_commerce.entity.user.Role;
import com.arifesonol.backende_commerce.entity.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserConverter {
    public static List<RoleResponse> convertToRoleResponseList(List<Role> roles) {
        List<RoleResponse> responses = new ArrayList<>();
        roles.forEach(role -> responses.add(new RoleResponse(
                role.getId(), role.getName(), role.getCode()
        )));
        return responses;
    }

    public static LoginResponse convertToUserResponse(User user){
        return new LoginResponse(user.getEmail(), user.getName(), user.getRoles().stream().findFirst().orElseThrow().getId().toString());
    }
}
