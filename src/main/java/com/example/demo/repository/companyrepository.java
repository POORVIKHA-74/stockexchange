package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.company;

public interface companyrepository extends CrudRepository<company, Integer> {

	public Iterable<company> deleteBycompanyname(String companyname);
	
	public company findBycompanyname(String companyname);

}
