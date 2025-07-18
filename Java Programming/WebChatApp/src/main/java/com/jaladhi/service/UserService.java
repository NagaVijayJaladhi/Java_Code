package com.jaladhi.service;

import com.jaladhi.exception.UsernameAlreadyUsedException;
import com.jaladhi.model.User;

public interface UserService {

	public User connect(User user) throws UsernameAlreadyUsedException;

	public User disconnect(User user);
}
