package com.medicare.admin;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity


public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int adminId;
private String admin;
private String password;



public Admin() {
	super();
}

public Admin(int adminId, String admin, String password) {
	super();
	this.adminId = adminId;
	this.admin = admin;
	this.password = password;
}

public int getAdminId() {
	return adminId;
}
public void setAdminId(int adminId) {
	this.adminId = adminId;
}
public String getAdmin() {
	return admin;
}
public void setAdmin(String admin) {
	this.admin = admin;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



}
