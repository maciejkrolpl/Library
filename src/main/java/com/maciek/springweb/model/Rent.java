package com.maciek.springweb.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime rentDate;
    private LocalDateTime returnDate;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="Rent_Book",
            joinColumns = { @JoinColumn (name="rent_id")},
            inverseJoinColumns = { @JoinColumn(name="book_id")})
    private Set<Book> rentedBooks;

    public LocalDateTime getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDateTime rentDate) {
        this.rentDate = rentDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Book> getRentedBooks() {
        return rentedBooks;
    }

    public void setRentedBooks(Set<Book> rentedBooks) {
        this.rentedBooks = rentedBooks;
    }

    public Rent(LocalDateTime rentDate, LocalDateTime returnDate, Set<Book> rentedBooks) {
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.rentedBooks = rentedBooks;
    }

    public Rent() {
    }
}