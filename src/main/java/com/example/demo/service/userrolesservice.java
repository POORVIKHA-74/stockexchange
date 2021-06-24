package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.userroles;
import com.example.demo.repository.userrolesrepository;

@Service
public class userrolesservice {

	 @Autowired
	 private userrolesrepository repo1;
	 
	 public userrolesservice() {}
	 
	public userrolesservice(userrolesrepository repo1) {
		super();
		this.repo1 = repo1;
	}
	
	public void savemyuserroles(userroles userroles)
	{
		repo1.save(userroles);
	}
}
