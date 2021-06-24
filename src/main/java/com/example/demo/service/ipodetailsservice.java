package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.ipodetails;
import com.example.demo.repository.ipodetailsrepository;

@Service
public class ipodetailsservice {

	@Autowired
	private ipodetailsrepository repo;

	public ipodetailsservice() {}
	public ipodetailsservice(ipodetailsrepository repo) {
		super();
		this.repo = repo;
	}
	
	public void savemyipo(ipodetails ipodetails)
	{
		repo.save(ipodetails);
	}
	
	public Iterable<ipodetails>showallipo()
	{
		return repo.findAll();
	}
	
	
	
}
