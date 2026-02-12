package com.example.app.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.News;
import com.example.app.service.NewsService;

import lombok.RequiredArgsConstructor;
@Controller
@RequestMapping("/admin/announcements")
@RequiredArgsConstructor
public class AdminAnnouncementController {
 private final NewsService newsService;
 
 @GetMapping("/form")
 public String form(Model model) {
	 model.addAttribute("newsList", newsService.getNewsList());  
	 
	 return "admin/announcements/form";
 }

 @GetMapping("/add")
 public String list(Model model) {
 model.addAttribute("news", new News());
 return "admin/announcements/form";
}
 @GetMapping("/{id}")
 public String detail(@PathVariable Integer id, Model model) {
 model.addAttribute("news", newsService.getNewsById(id));
 return "news/detail";
 }

}