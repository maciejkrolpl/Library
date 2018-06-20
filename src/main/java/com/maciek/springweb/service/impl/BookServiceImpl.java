package com.maciek.springweb.service.impl;

import com.maciek.springweb.dto.BookCreateDto;
import com.maciek.springweb.model.Author;
import com.maciek.springweb.model.Book;
import com.maciek.springweb.model.Rent;
import com.maciek.springweb.repository.BookRepository;
import com.maciek.springweb.repository.RentRepository;
import com.maciek.springweb.service.AuthorService;
import com.maciek.springweb.service.BookService;
import com.maciek.springweb.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private AuthorService authorService;
    private RentRepository rentRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, RentRepository rentRepository) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.rentRepository = rentRepository;
    }

    @Override
    public Book findOneById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(RuntimeException::new);
    }

    @Override
    public Set<Book> findAll() {
        return new HashSet<>(bookRepository.findAll());
    }

    @Override
    public void deleteOneById(Long id) {
        bookRepository.deleteById(id);

    }

    @Override
    public Book createBook(BookCreateDto bookCreateDto) {
        Book book = new Book();
        Author author = authorService.findOneById(bookCreateDto.getAuthorId());

        book.setTitle(bookCreateDto.getTitle());
        book.setAuthor(author);

        return bookRepository.save(book);

    }

    @Override
    public Set<Book> getBooksByRentId(Long id) {
        Optional<Rent> optionalRent = rentRepository.findById(id);
        if (optionalRent.isPresent()) {
            Rent rent = optionalRent.get();
            return rent.getRentedBooks();
        } else {
            throw new RuntimeException();
        }

    }


}
