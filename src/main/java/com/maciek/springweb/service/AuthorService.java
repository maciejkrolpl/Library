package com.maciek.springweb.service;

import com.maciek.springweb.dto.AuthorCreateDto;
import com.maciek.springweb.model.Author;

import java.util.Set;

public interface AuthorService {

    Author findOneById(Long id);

    Set<Author> findAll();

    void deleteOneById(Long id);

    Author createAuthor(AuthorCreateDto authorCreateDto);

    Author findAuthorByBookId(Long id);


}
