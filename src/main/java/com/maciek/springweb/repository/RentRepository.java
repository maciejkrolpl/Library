package com.maciek.springweb.repository;

import com.maciek.springweb.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, Long> {
}
