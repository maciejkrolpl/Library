package com.maciek.springweb.controller;

import com.maciek.springweb.dto.BookCreateDto;
import com.maciek.springweb.dto.BookDto;
import com.maciek.springweb.model.Book;
import com.maciek.springweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/{id}")
    public BookDto findById(@PathVariable Long id) {
        Book book = bookService.findOneById(id);
        return new BookDto(book);
    }

    @GetMapping
    public Set<BookDto> findAll() {
        Set<BookDto> result = new HashSet<>();
        Set<Book> all = bookService.findAll();
        all.forEach(b -> result.add(new BookDto(b)));
        return result;
    }


    @PostMapping
    public BookDto create(@RequestBody BookCreateDto bookCreateDto) {

        Book book = bookService.createBook(bookCreateDto);
        return new BookDto(book);

    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteOneById(id);
    }


}
