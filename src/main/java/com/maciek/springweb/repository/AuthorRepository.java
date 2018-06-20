package com.maciek.springweb.repository;

import com.maciek.springweb.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
