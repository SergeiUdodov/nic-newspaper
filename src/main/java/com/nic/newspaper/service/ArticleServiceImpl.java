package com.nic.newspaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nic.newspaper.dao.ArticleDao;
import com.nic.newspaper.entity.Article;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public List<Article> getArticles() {
		
		List<Article> theArticles = articleDao.getArticles();
		
		return theArticles;
	}

}
