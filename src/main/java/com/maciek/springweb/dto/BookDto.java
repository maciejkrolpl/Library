package com.maciek.springweb.dto;

import com.maciek.springweb.model.Address;
import com.maciek.springweb.model.Book;
import com.maciek.springweb.model.Gender;

public class BookDto {
    private Long id;
    private String title;
    private String authorFirstName;
    private String authorLastName;
    private Gender authorGender;
    private Long authorId;

    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.authorFirstName = book.getAuthor().getFirstName();
        this.authorLastName = book.getAuthor().getLastName();
        this.authorGender = book.getAuthor().getGender();
        this.authorId = book.getAuthor().getId();
    }

    public BookDto() {
    }


    public Gender getAuthorGender() {
        return authorGender;
    }

    public void setAuthorGender(Gender authorGender) {
        this.authorGender = authorGender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}
