package com.example.app.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.Admin;
import com.example.app.service.AdminService;

import lombok.RequiredArgsConstructor;


@RequestMapping("/admin")
@Controller
@RequiredArgsConstructor
public class AdminAuthController {
	
		private final AdminService service;
		private final HttpSession session;
		
		@GetMapping("/login")
		public String AdminHost(Model model) {
			model.addAttribute("admin", new Admin());
			return "admin/login";
		}
		@GetMapping("/dashboard")
		public String Dashboard() {
			return "admin/dashboard";
		}
		
		@PostMapping("/login")
		public String login( 
			@Valid Admin admin,
			Errors errors) {
				// 入力に不備がある
				if(errors.hasErrors()) {
					return "admin/login";
				}
				String loginId = admin.getLoginId();
				String loginPass = admin.getLoginPass();
				
				//ログインID・パスワード
				//=>セッションにログインIDを格納し、リダイレクト
				session.setAttribute("loginId", loginId);
				return "redirect:/";
			}
			
			@GetMapping("/logout")
			public String logout() {
				//セッションを破棄し、トップページへ遷移
				session.invalidate();
				return "redirect:/loginHome";
			
			
		}
}
