package com.maciek.springweb.repository;

import com.maciek.springweb.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    boolean existsBookByAuthorId(Long id);
}
