package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class userroles {

	@Id
	private int id;
	private String username;
	private String pass;
	private String usertype;
	private String email;
	private int num;
	private String confirmed;
	
	
	public userroles() {}
	
	public userroles(int id, String username, String pass, String usertype, String email, int num, String confirmed) {
		super();
		this.id = id;
		this.username = username;
		this.pass = pass;
		this.usertype = usertype;
		this.email = email;
		this.num = num;
		this.confirmed = confirmed;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(String confirmed) {
		this.confirmed = confirmed;
	}
	
	
	
	
}
