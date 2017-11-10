package com.hellokoding.auth.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hellokoding.auth.dao.HelloLogDao;
import com.hellokoding.auth.model.HelloLog;

@Controller
public class HelloControllers {
	
	@Autowired
	private HelloLogDao helloLogDao;

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloForm() {
		return "helloform";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String hello(HttpServletRequest request, Model model) {

		String name = request.getParameter("name");

		if (name == null || name == "") {
			name = "world";
		}
		
		HelloLog log = new HelloLog(name);
		helloLogDao.save(log);
		
		model.addAttribute("name", name);
		model.addAttribute("title", "Hello, Spring ... Response");
		model.addAttribute("mode", "MODE_HOME");

		return "firstPage"; 

	}
	
//	@RequestMapping(value = "/hellosuccess", method = RequestMethod.GET)
//	public String helloSuccess() {
//		return "hello";
//	}
}
