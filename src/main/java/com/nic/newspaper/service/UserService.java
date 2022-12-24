package com.nic.newspaper.service;

import com.nic.newspaper.entity.User;
import com.nic.newspaper.user.CrmUser;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);

	public User findByUserEmail(String userEmail);
}
