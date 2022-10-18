package com.obs.helper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.obs.admin.model.Admin;

@Controller
public class HelperController {
	@RequestMapping("start")
	public String startApp(Model m) {
		m.addAttribute("admin", new Admin());
		return "admin/adminLoginPage";
	}
	

}
