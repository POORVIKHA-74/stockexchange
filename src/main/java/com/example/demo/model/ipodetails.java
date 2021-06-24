package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="ipo")
public class ipodetails {

	@Id
	private int id;
	private String companyname;
	private String stockexchange;
	private int pricepershare;
	private int totalshares;
	private String opendate;
	private String remarks;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="company_ipo",
			   joinColumns=@JoinColumn(name="ipo_id"),
			   inverseJoinColumns=@JoinColumn(name="company_id")
	)
	private Collection<company>company=new ArrayList<>();
	
	public ipodetails() {}
	
	public ipodetails(int id, String companyname, String stockexchange, int pricepershare, int totalshares,
			String opendate, String remarks) {
		super();
		this.id = id;
		this.companyname = companyname;
		this.stockexchange = stockexchange;
		this.pricepershare = pricepershare;
		this.totalshares = totalshares;
		this.opendate = opendate;
		this.remarks = remarks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getStockexchange() {
		return stockexchange;
	}

	public void setStockexchange(String stockexchange) {
		this.stockexchange = stockexchange;
	}

	public int getPricepershare() {
		return pricepershare;
	}

	public void setPricepershare(int pricepershare) {
		this.pricepershare = pricepershare;
	}

	public int getTotalshares() {
		return totalshares;
	}

	public void setTotalshares(int totalshares) {
		this.totalshares = totalshares;
	}

	public String getOpendate() {
		return opendate;
	}

	public void setOpendate(String opendate) {
		this.opendate = opendate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Collection<company> getCompany() {
		return company;
	}

	public void setCompany(Collection<company> company) {
		this.company = company;
	}

	
	
	
	
	
}
