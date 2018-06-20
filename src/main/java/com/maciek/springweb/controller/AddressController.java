package com.maciek.springweb.controller;

import com.maciek.springweb.dto.AddressCreateDto;
import com.maciek.springweb.dto.AddressDto;
import com.maciek.springweb.model.Address;
import com.maciek.springweb.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/address")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public Set<Address> findAll() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id) {
        return addressService.findById(id);
    }

    @PostMapping
    public AddressDto create(@RequestBody AddressCreateDto addressCreateDto) {
        Address address = addressService.createAddress(addressCreateDto);
        return new AddressDto(address);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress (@PathVariable Long id) {
        addressService.deleteOneById(id);
    }
}
