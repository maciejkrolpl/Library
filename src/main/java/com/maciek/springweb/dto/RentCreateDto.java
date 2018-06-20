package com.maciek.springweb.dto;

import java.util.Set;

public class RentCreateDto {
    private Set<Long> bookIdSet;

    public RentCreateDto() {
    }

    public Set<Long> getBookIdSet() {
        return bookIdSet;
    }

    public void setBookIdSet(Set<Long> bookIdSet) {
        this.bookIdSet = bookIdSet;
    }

}
