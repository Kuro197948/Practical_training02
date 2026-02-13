package com.example.app.controller;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.NewsForm;
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
 
 @GetMapping("/submit")
 public String addGet(Model model) {
 model.addAttribute("newsForm", new NewsForm());
 return "admin/announcements/submit";
 }

 @PostMapping("/submit")
 public String submitPost(
 HttpSession session,
 @Valid @ModelAttribute("newsForm") NewsForm newsForm,
 Errors errors,
 RedirectAttributes ra,
 Model model) {
	 if(errors.hasErrors()) {
	 return "admin/announcements/submit";
	 newsService.addNews(newsForm); 
	 ra.addFlashAttribute("message", "お知らせを追加しました");
	 return "redirect:/admin/announcements/form";
	
	 }
return "redirect:/admin/announcements/form";
}
 

 
 @GetMapping("/{id:\\d+}")
 public String detail(@PathVariable Integer id, Model model) {
 model.addAttribute("news", newsService.getNewsById(id));
 return "admin/announcements/detail";
 }
 @GetMapping("/list")
 public String list() {
	return "admin/announcements/list";
 }

}