package com.example.app.domain;

import java.time.LocalDate;

import lombok.Data;

@Data
public class News {
	
	private Integer id;
	private String title;
	private String author;
	private LocalDate postDate;
	private NewsDetail detail;
	
}
