package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.company;
import com.example.demo.repository.companyrepository;

@Service
public class companyservice {

	 @Autowired
	 private companyrepository repo;

	 public companyservice() {}
	 
	public companyservice(companyrepository repo) {
		super();
		this.repo = repo;
	}
	 
	 public void savemycompany(company company)
	 {
		 repo.save(company);
		 
	 }
	 
	 
	 public Iterable<company> showallcompany()
	 {
		 return repo.findAll();
	 }
	  
	 public Iterable<company> deletecompanyBycompanyname(String companyname)
	 {
		 repo.deleteBycompanyname(companyname);
		 return repo.findAll();
	 }
	 
	 public company findBycompanyname(String companyname)
	 {
		 return repo.findBycompanyname(companyname);
	 }
	 
	 public void companyupdate(company company,company newcompany)
	 {
		 company.setTurnover(newcompany.getTurnover());
		 company.setCeo(newcompany.getCeo());
		 company.setBod(newcompany.getBod());
		// company.setListed(newcompany.getListed());
		 company.setSector(newcompany.getSector());
		 company.setWriteup(newcompany.getWriteup());
		 //company.setStockcode(newcompany.getStockcode());
		  repo.save(company);
	 }
	 
}
