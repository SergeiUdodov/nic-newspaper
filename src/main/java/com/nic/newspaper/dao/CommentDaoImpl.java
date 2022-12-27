package com.nic.newspaper.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nic.newspaper.entity.Comment;

	@Repository
	public class CommentDaoImpl implements CommentDao {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Comment> getCommnets() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Comment> theQuery = currentSession.createQuery("from Comment order by date", Comment.class);
		
		List<Comment> comments = theQuery.getResultList();
		
		return comments;
	}

}
