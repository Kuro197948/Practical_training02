package com.example.app.service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.News;
import com.example.app.mapper.NewsMapper;

import lombok.RequiredArgsConstructor;
@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {
 private final NewsMapper newsMapper;
 @Override
 public List<News> getNewsList() {
 return newsMapper.selectAll();
 }
 @Override
 public News getNewsById(Integer id) {
 return newsMapper.selectById(id);
 }
}