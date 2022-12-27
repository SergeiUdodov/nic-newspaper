package com.nic.newspaper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nic.newspaper.dao.CommentDao;
import com.nic.newspaper.entity.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;
	
	@Override
	public List<Comment> getCommnets() {
		
		List<Comment> theComments = commentDao.getCommnets();
		
		return theComments;
	}

}
