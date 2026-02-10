package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/announcements")
public class AdminAnnouncementController {
		@GetMapping("/form")
		public String formPage() {
			return "admin/announcements/form";
		}
		
		@GetMapping("list")
		public String listPage() {
			return "admin/announcements/list";
		}
}
