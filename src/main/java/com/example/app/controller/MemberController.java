package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MemberController {
		@GetMapping("member/login")
		public String MemberLoginPage() {
			return "member/login";
		}
		@GetMapping("member/announcements/list")
		public String MemberList () {
			return "member/announcements/list";
		}
}
