package com.maciek.springweb.controller;

import com.maciek.springweb.dto.AuthorCreateDto;
import com.maciek.springweb.dto.AuthorDto;
import com.maciek.springweb.model.Author;
import com.maciek.springweb.model.Book;
import com.maciek.springweb.service.AuthorService;
import com.maciek.springweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    public AuthorController() {
    }

    @GetMapping("/{id}")
    public AuthorDto findById(@PathVariable Long id) {
        Author author = authorService.findOneById(id);
        return new AuthorDto(author);
    }

    @GetMapping
    public Set<AuthorDto> findAll() {
        Set<AuthorDto> result = new HashSet<>();
        Set<Author> authors = authorService.findAll();
        authors.forEach(a -> result.add(new AuthorDto(a)));
        return  result;
    }

    @GetMapping("/book/{id}")
    public AuthorDto findAuthorByBookId(@PathVariable Long id) {
        Author author = authorService.findAuthorByBookId(id);
        return new AuthorDto(author);
    }


    @PostMapping
    public AuthorDto create(@RequestBody AuthorCreateDto authorCreateDto) {

        Author author = authorService.createAuthor(authorCreateDto);

        return new AuthorDto(author);

    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteOneById(id);
    }

}
