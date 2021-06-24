package com.example.demo.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.model.ipodetails;
import com.example.demo.service.ipodetailsservice;

@org.springframework.web.bind.annotation.RestController
public class ipodetailscontroller {
	
	@Autowired
	private ipodetailsservice service;
	
	@PostMapping("/save-ipo")
	@Transactional
	public String registeripo(@RequestBody ipodetails ipodetails)
	{
		service.savemyipo(ipodetails);
		return "ipo "+ipodetails.getCompanyname()+" has been added";
	}
	
	@GetMapping("/all-ipo")
	public Iterable<ipodetails>showallipo()
	{
		return service.showallipo();
	}
	
	

	
	

}
