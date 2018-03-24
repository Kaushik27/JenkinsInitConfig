package com.knight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.knight.service.myService;

@Controller
public class myController {
	
	@Autowired
	myService service;

	@GetMapping("/hello")
	public @ResponseBody String sayHello(){
		return "hello";
	}
	
	@GetMapping("getData")
	public @ResponseBody Object getDataFromDb(@RequestParam("id") String id){
		System.err.println(id);
		return service.getDataFromService(id);
	}
}
