package com.maciek.springweb.controller;

import com.maciek.springweb.model.Book;
import com.maciek.springweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
@RequestMapping("/html/books")
public class LibraryController {

    private BookService bookService;

    @Autowired
    public LibraryController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String findAll(Model model) {
        Set<Book> bookSet = bookService.findAll();
        model.addAttribute("books", bookSet);
        return "books";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        Book book = bookService.findOneById(id);
        model.addAttribute("book", book);
        return "book";
    }


}
