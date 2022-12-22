package com.luv2code.springsecurity.demo.dao;

import com.luv2code.springsecurity.demo.entity.User;

public interface UserDao {
    
    public void save(User user);

	public User findByUserEmail(String theUserEmail);
    
}
