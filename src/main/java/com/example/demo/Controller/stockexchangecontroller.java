package com.example.demo.Controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.stockexchange;
import com.example.demo.service.stockexchangeservice;

@org.springframework.web.bind.annotation.RestController
public class stockexchangecontroller {

	 @Autowired
	 private stockexchangeservice service;
	 
	 @PostMapping("/save-stock")
	 @Transactional
	 public String registerstock(@RequestBody stockexchange stockexchange)
	 {
		 service.savestockexchange(stockexchange);
		 return "ergistered"+stockexchange.getStockexchange();
	 }
	 
	 @GetMapping("/all-stock")
	 public Iterable<stockexchange>showallstock()
	 {
		 return service.showallstock();
	 }
}
