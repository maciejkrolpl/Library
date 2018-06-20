package com.maciek.springweb.service;

import com.maciek.springweb.dto.AddressCreateDto;
import com.maciek.springweb.model.Address;

import java.util.Set;

public interface AddressService {

    Address findById(Long id);

    Set<Address> findAll();

    void deleteOneById(Long id);

    Address createAddress(AddressCreateDto addressCreateDto);

}
