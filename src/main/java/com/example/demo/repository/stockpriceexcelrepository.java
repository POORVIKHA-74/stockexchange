package com.example.demo.repository;

//import org.springframework.data.repository.CrudRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.stockpriceexcel;

public interface stockpriceexcelrepository  extends JpaRepository<stockpriceexcel,Integer>{

}
