package com.arifesonol.backende_commerce.services.user;

import com.arifesonol.backende_commerce.dto.AddressRequest;
import com.arifesonol.backende_commerce.dto.AddressResponse;
import com.arifesonol.backende_commerce.entity.user.Address;
import com.arifesonol.backende_commerce.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Optional<Address> findById(Long id);

    List<AddressResponse> getAllAddress(User user);

    Address save(User user, AddressRequest addressRequest);

    AddressResponse update(User user, AddressRequest addressRequest);

    boolean delete(User user, Long addressId);

}