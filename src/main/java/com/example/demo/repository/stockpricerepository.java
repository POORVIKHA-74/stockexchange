package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.stockprice;

public interface stockpricerepository extends JpaRepository<stockprice,Long> {

}
