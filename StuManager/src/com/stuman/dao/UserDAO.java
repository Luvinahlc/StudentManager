package com.stuman.dao;

import com.stuman.domain.User;

public interface UserDAO {
	
	boolean addUser(User user);
	
	boolean deleteUserById(String id);
	
	boolean updateUser(User user);
}
