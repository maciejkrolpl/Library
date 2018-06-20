package com.maciek.springweb.service.impl;

import com.maciek.springweb.dto.RentCreateDto;
import com.maciek.springweb.model.Book;
import com.maciek.springweb.model.Rent;
import com.maciek.springweb.repository.RentRepository;
import com.maciek.springweb.service.BookService;
import com.maciek.springweb.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RentServiceImpl implements RentService {

    private RentRepository rentRepository;
    private BookService bookService;

    @Autowired
    public RentServiceImpl(RentRepository rentRepository, BookService bookService) {
        this.rentRepository = rentRepository;
        this.bookService = bookService;
    }

    @Override
    public Set<Rent> findAll() {
        return new HashSet<>(rentRepository.findAll());
    }

    @Override
    public Rent findById(Long id) {
        return rentRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Rent createRent(RentCreateDto rentCreateDto) {
        Rent rent = new Rent();
        rent.setRentDate(LocalDateTime.now());
        Set<Long> bookIdSet = rentCreateDto.getBookIdSet();
        Set<Book> bookSet = new HashSet<>();
        for (Long aLong : bookIdSet) {
            bookSet.add(bookService.findOneById(aLong));
        }
        rent.setRentedBooks(bookSet);
        return rentRepository.save(rent);
    }

    @Override
    public Rent setRentReturned(Long id) {
        Optional<Rent> optionalRent = rentRepository.findById(id);
        if (optionalRent.isPresent()) {
            Rent rent = optionalRent.get();
            if (rent.getReturnDate() == null) {
                rent.setReturnDate(LocalDateTime.now());
                return rentRepository.save(rent);
            }
        }
        throw new RuntimeException();
    }


}
