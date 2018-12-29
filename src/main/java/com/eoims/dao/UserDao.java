package com.eoims.dao;

import com.eoims.domain.User;
import com.eoims.domain.UserRole;

public interface UserDao extends BaseDao{
	
	public User findUserByName(String username);
	
	public void delRolesByUserId(String userId);
	
	public void addUserRole(UserRole userRole);
	
	public User queryByName(String username);
}
