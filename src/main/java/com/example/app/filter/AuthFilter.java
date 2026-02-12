package com.example.app.filter;
import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AuthFilter implements Filter {
	
	@Override
 public void doFilter(ServletRequest request, ServletResponse response,
FilterChain chain)
 throws IOException, ServletException {
		
 HttpServletRequest req = (HttpServletRequest) request;
 HttpServletResponse res = (HttpServletResponse) response;
 HttpSession session = req.getSession(false);
 //Java Servletにおいて、HTTPリクエストのコンテキストパス以降の
 //パス（/で始まる）を取得するメソッド
 String uri=req.getRequestURI();
 //①除外(ここは認証不要)
 if (uri.equals("/loginHome")
	 ||uri.equals("/admin/login")
	 ||uri.startsWith("/css/")
	 ||uri.startsWith("/js/")
	 ||uri.startsWith("/images/")
	 ||uri.startsWith("/uploads/")) {
	 chain.doFilter(request, response);

 return;
 }
	//②未ログインなら入口へ
	Object loginId = (session == null) ? null:session.getAttribute("loginId");
	if(loginId==null) {
		res.sendRedirect("/loginHome?needLogin=1");
		return;
	}
	res.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");
	res.setHeader("Pragma", "no-cache");
	res.setDateHeader("Expires", 0);

 chain.doFilter(request, response);
 }
}
