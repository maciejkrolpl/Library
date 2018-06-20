package com.maciek.springweb.dto;

import com.maciek.springweb.model.Book;
import com.maciek.springweb.model.Rent;

import java.time.LocalDateTime;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class RentDto {

    private Long rentId;
    private LocalDateTime rentDate;
    private LocalDateTime returnDate;
    private Set<Long> bookId;

    public RentDto(Rent rent) {
        this.rentId = rent.getId();
        this.rentDate = rent.getRentDate();
        this.returnDate = rent.getReturnDate();
        this.bookId = rent.getRentedBooks().stream()
                .map(Book::getId)
                .collect(toSet());
    }

    public RentDto() {
    }

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

    public Long getRentId() {
        return rentId;
    }

    public void setRentId(Long rentId) {
        this.rentId = rentId;
    }

    public Set<Long> getBookId() {
        return bookId;
    }

    public void setBookId(Set<Long> bookId) {
        this.bookId = bookId;
    }
}
