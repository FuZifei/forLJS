package com.frank.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloMVC2 {
	

	@RequestMapping("/upload")
public String react() {
	System.out.print("succeed");
	return "uploaddemo";
}
}
