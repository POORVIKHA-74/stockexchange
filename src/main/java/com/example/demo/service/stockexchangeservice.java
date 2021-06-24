package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.stockexchange;
import com.example.demo.repository.stockexchangerepository;

@Service
public class stockexchangeservice {
	
	@Autowired
	 private stockexchangerepository repo;

	public stockexchangeservice() {}
	public stockexchangeservice(stockexchangerepository repo) {
		super();
		this.repo = repo;
	}
	
	public void savestockexchange(stockexchange stockexchange)
	{
		repo.save(stockexchange);
	}
	
	public Iterable<stockexchange>showallstock()
	{
		return repo.findAll();
	}
	
	

}
