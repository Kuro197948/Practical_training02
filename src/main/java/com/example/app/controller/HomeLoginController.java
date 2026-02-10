package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeLoginController {
		@GetMapping("/loginHome")
		public String LoginHome() {
			return "loginHome";
		}
}
