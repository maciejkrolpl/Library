package com.maciek.springweb.service;

import com.maciek.springweb.dto.RentCreateDto;
import com.maciek.springweb.model.Rent;

import java.util.Set;

public interface RentService {
    Set<Rent> findAll();
    Rent findById(Long id);
    Rent createRent(RentCreateDto rentCreateDto);
    Rent setRentReturned(Long id);

}
