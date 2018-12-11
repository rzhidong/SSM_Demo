package com.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.service.TestService;

@Controller
public class TestController {
	
	@RequestMapping("/springmvc")
	@ResponseBody
	public String springmvc() {
		return "springmvc test success";
	}
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/spring")
	@ResponseBody
	public String spring() {
		return testService.testSpring();
	}
	
	@RequestMapping("/mybatis")
	@ResponseBody
	public String mybatis() {
		return testService.testDB();
	}
}
