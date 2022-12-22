package com.luv2code.springsecurity.demo.service;

import com.luv2code.springsecurity.demo.entity.User;
import com.luv2code.springsecurity.demo.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService{

	public void save(CrmUser crmUser);

	public User findByUserEmail(String userEmail);
}
