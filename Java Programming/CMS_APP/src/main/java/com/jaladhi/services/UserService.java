package com.jaladhi.services;

import com.jaladhi.entity.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);
}
