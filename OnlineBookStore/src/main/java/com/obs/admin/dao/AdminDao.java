package com.obs.admin.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.obs.admin.model.Admin;

public interface AdminDao extends JpaRepository<Admin,String>{
	Admin findByAdminEmail(String adminEmail);

	Admin findByAdminEmailAndAdminPassword(String adminEmail, String adminPassword);

}
