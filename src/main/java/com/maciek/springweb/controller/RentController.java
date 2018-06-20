package com.maciek.springweb.controller;

import com.maciek.springweb.dto.RentCreateDto;
import com.maciek.springweb.dto.RentDto;
import com.maciek.springweb.model.Rent;
import com.maciek.springweb.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/rents")
public class RentController {

    private RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping
    public Set<RentDto> findAll() {
        Set<RentDto> result = new HashSet<>();
        Set<Rent> rentSet = rentService.findAll();
        rentSet.forEach(r -> result.add(new RentDto(r)));
        return result;
    }

    @GetMapping("/{id}")
    public RentDto findById(@PathVariable Long id) {
        Rent rent = rentService.findById(id);
        return new RentDto(rent);
    }

    @PostMapping
    public RentDto createRent(@RequestBody RentCreateDto rentCreateDto) {
        Rent rent = rentService.createRent(rentCreateDto);
        return new RentDto(rent);
    }

    @GetMapping("/return/{id}")
    public RentDto setRentReturned(@PathVariable Long id) {
        Rent rent = rentService.setRentReturned(id);
        return new RentDto(rent);

    }
}
