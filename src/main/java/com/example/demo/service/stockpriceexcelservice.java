package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.helper.stockpriceexcelhelper;
import com.example.demo.model.stockpriceexcel;
import com.example.demo.repository.stockpriceexcelrepository;

@Service
public class stockpriceexcelservice {

	@Autowired
	stockpriceexcelrepository repo;
	
	public void save(MultipartFile file) {
	try {	System.out.print("in");
		List<stockpriceexcel> finallist=stockpriceexcelhelper.exceltostockprice(file.getInputStream());
		repo.saveAll(finallist);
		repo.findAll();
	}
	catch(IOException e) {
		throw new RuntimeException("fail to store excel data:"+e.getMessage());
	}
	}
	
	/*public List<stockpriceexcel>getAllstockprice()
	{
		return repo.findAll();
	}*/
	
}
