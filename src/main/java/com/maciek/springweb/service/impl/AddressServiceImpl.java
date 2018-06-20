package com.maciek.springweb.service.impl;

import com.maciek.springweb.dto.AddressCreateDto;
import com.maciek.springweb.model.Address;
import com.maciek.springweb.repository.AddressRepository;
import com.maciek.springweb.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AddressServiceImpl implements AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public Address findById(Long id) {
        Optional<Address>  optionalAddress =  addressRepository.findById(id);
        return optionalAddress.orElseThrow(RuntimeException::new);
    }

    @Override
    public Set<Address> findAll() {

        return new HashSet<>(addressRepository.findAll());
    }

    @Override
    public void deleteOneById(Long id) {
        addressRepository.deleteById(id);

    }

    @Override
    public Address createAddress(AddressCreateDto addressCreateDto) {
        Address address = new Address();
        address.setStreet(addressCreateDto.getStreet());
        address.setCity(addressCreateDto.getCity());
        address.setState(addressCreateDto.getState());
        return addressRepository.save(address);
    }
}
