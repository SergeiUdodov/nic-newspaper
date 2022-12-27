package com.nic.newspaper.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nic.newspaper.entity.Article;

@Repository
public class ArticleDaoImpl implements ArticleDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Article> getArticles() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Article> theQuery = currentSession.createQuery("from Article order by header", Article.class);
		
		List<Article> articles = theQuery.getResultList();
		
		return articles;
	}

}
