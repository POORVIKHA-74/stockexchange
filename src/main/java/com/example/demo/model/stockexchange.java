package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stockexchange")
public class stockexchange {
	
	@Id
	private int id;
	private String stockexchange;
	private String brief;
	private String contactaddress;
	private String remarks;
	
	public stockexchange() {}

	public stockexchange(int id, String stockexchange, String brief, String contactaddress, String remarks) {
		super();
		this.id = id;
		this.stockexchange = stockexchange;
		this.brief = brief;
		this.contactaddress = contactaddress;
		this.remarks = remarks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStockexchange() {
		return stockexchange;
	}

	public void setStockexchange(String stockexchange) {
		this.stockexchange = stockexchange;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContactaddress() {
		return contactaddress;
	}

	public void setContactaddress(String contactaddress) {
		this.contactaddress = contactaddress;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	

}
