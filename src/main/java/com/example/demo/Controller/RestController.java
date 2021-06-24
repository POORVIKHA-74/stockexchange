package com.example.demo.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.model.company;
import com.example.demo.service.companyservice;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	private companyservice service;
	
	@PostMapping("/save-company")
	@Transactional
	public String registercompany(@RequestBody company company)
	{
	
	   service.savemycompany(company);
	   return "company "+company.getCompanyname()+"registered";	
	}
	
	@GetMapping("/all-company")
	public Iterable<company> showallcompany()
	{
		return service.showallcompany();
	}
	
	@GetMapping("/del-company/{companyname}")
	@Transactional
	public Iterable<company> deletecompany(@PathVariable String companyname)
	{
		return service.deletecompanyBycompanyname(companyname);
	}
	
	@GetMapping("/search-company/{companyname}")
	public company searchcompany(@PathVariable String companyname)
	{
		return service.findBycompanyname(companyname);
	}
	
	/*@PutMapping("/update-company")
	public company update(@RequestBody company company)
	{
		return service.companyupdate(company);
		
	}*/
	
	@PostMapping("/update-company/{companyname}")
	@Transactional
	public String update(@PathVariable String companyname,@RequestBody company newcompany)
	{
		company temp=service.findBycompanyname(companyname);
		service.companyupdate(temp,newcompany);
		return "company "+temp.getCompanyname()+"has been updated"+temp.getCeo();

				
	}

}
