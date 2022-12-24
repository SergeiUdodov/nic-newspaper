package com.nic.newspaper.dao;

import com.nic.newspaper.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
