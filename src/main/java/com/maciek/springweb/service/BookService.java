package com.maciek.springweb.service;

import com.maciek.springweb.dto.BookCreateDto;
import com.maciek.springweb.model.Book;

import java.util.Set;

public interface BookService {

    Book findOneById(Long id);
    Set<Book> findAll();
    void deleteOneById(Long id);
    Book createBook(BookCreateDto bookCreateDtoDto);
    Set<Book> getBooksByRentId(Long id);
}
