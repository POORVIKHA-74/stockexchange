package com.example.demo.service;

import java.util.List;

import com.example.demo.model.stockprice;

public interface exceldataservice {
	
	List<stockprice> getExcelDataAsList();
	int saveExcelData(List<stockprice> stockprice);

}
