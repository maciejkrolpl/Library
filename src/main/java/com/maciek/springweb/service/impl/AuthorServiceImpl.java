package com.maciek.springweb.service.impl;

import com.maciek.springweb.dto.AuthorCreateDto;
import com.maciek.springweb.dto.AuthorDto;
import com.maciek.springweb.model.Address;
import com.maciek.springweb.model.Author;
import com.maciek.springweb.model.Book;
import com.maciek.springweb.repository.AuthorRepository;
import com.maciek.springweb.repository.BookRepository;
import com.maciek.springweb.service.AddressService;
import com.maciek.springweb.service.AuthorService;
import com.maciek.springweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AuthorServiceImpl implements AuthorService {


    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private AddressService addressService;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, BookRepository bookRepository, AddressService addressService) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.addressService = addressService;
    }


    @Override
    public Author findOneById(Long id) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        return optionalAuthor.orElseThrow(RuntimeException::new);
    }

    @Override
    public Set<Author> findAll() {
        return new HashSet<>(authorRepository.findAll());
    }

    public Author findAuthorByBookId(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book;
        if (optionalBook.isPresent()) {
            book = optionalBook.get();
            return book.getAuthor();
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public void deleteOneById(Long id) {
        boolean ifBooksByAuthorExist = bookRepository.existsBookByAuthorId(id);
        if (!ifBooksByAuthorExist) {
            authorRepository.deleteById(id);
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public Author createAuthor(AuthorCreateDto authorCreateDto) {

        Author author = new Author();
        Address address = addressService.findById(authorCreateDto.getAddressId());

        author.setAddress(address);
        author.setFirstName(authorCreateDto.getFirstName());
        author.setLastName(authorCreateDto.getLastName());
        author.setGender(authorCreateDto.getGender());

        return authorRepository.save(author);
    }
}
