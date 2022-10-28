package com.cybage.dao;

import com.cybage.entity.User;

public interface UserDao {
	void registration(User user);
	User getUserByEmail(String email);
	boolean login(User user);
}
