package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stockprice")
public class stockprice {
	
	
	@Id
	 private int id;
	 private int companyid;
	 private int stockexchangeid;
	 private int currentprice;
	 private String date;
	 private String time;
	 
	 public stockprice() {}
	public stockprice(int id, int companyid, int stockexchangeid, int currentprice, String date, String time) {
		super();
		this.id = id;
		this.companyid = companyid;
		this.stockexchangeid = stockexchangeid;
		this.currentprice = currentprice;
		this.date = date;
		this.time = time;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public int getStockexchangeid() {
		return stockexchangeid;
	}
	public void setStockexchangeid(int stockexchangeid) {
		this.stockexchangeid = stockexchangeid;
	}
	public int getCurrentprice() {
		return currentprice;
	}
	public void setCurrentprice(int currentprice) {
		this.currentprice = currentprice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	 

}
