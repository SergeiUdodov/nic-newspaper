package com.nic.newspaper.dao;

import com.nic.newspaper.entity.User;

public interface UserDao {

    public User findByUserName(String userName);
    
    public void save(User user);

	public User findByUserEmail(String userEmail);
    
}
