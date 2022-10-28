package com.cybage.service;

import com.cybage.entity.User;

public interface UserService {
	void registration(User user);
	User getUserByEmail(String email);
	boolean login(User user);
}
