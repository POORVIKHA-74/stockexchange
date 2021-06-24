package com.example.demo.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class company {
	
	@Id
	private int id;
	private String companyname;
	private double turnover;
	private String ceo;
	private String bod;
	//private String listed;
	private String sector;
	private String writeup;

	@ManyToMany(mappedBy="company",cascade=CascadeType.ALL)
	private Collection<ipodetails>ipodetails=new ArrayList<>();
		
	public company() {}
	public company(int id, String companyname, double turnover, String ceo, String bod, String sector,
			String writeup) {
		super();
		this.id = id;
		this.companyname = companyname;
		this.turnover = turnover;
		this.ceo = ceo;
		this.bod = bod;
		//this.listed = listed;
		this.sector = sector;
		this.writeup = writeup;
		//this.stockcode = stockcode;
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
	public double getTurnover() {
		return turnover;
	}
	public void setTurnover(double turnover) {
		this.turnover = turnover;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getBod() {
		return bod;
	}
	public void setBod(String bod) {
		this.bod = bod;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getWriteup() {
		return writeup;
	}
	public void setWriteup(String writeup) {
		this.writeup = writeup;
	}

	public Collection<ipodetails> getIpodetails() {
		return ipodetails;
	}
	public void setIpodetails(Collection<ipodetails> ipodetails) {
		this.ipodetails = ipodetails;
	}

}
