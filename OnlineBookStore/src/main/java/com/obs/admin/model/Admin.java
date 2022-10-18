package com.obs.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
public class Admin {
	@Id
	private String adminId;
	
	@Size(min = 4, message = "Name must be minimum 4 characters long")
	private String adminName;
	
	@Size(min=10,max=10, message = "Mobile must contain 10 digits")
	private String adminMobile;
	
	@Column(unique = true)
	@Email
	private String adminEmail;
	
	@Size(min = 4, message = "Password must be minimum 4 characters long")
	private String adminPassword;
	
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminMobile() {
		return adminMobile;
	}
	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	
	
	
	

}
