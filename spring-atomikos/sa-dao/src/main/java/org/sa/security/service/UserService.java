package org.sa.security.service;

import java.util.List;

import org.sa.bean.security.Role;
import org.sa.bean.security.User;

public interface UserService {

	public List<User> getAll();
	
	public void insert(User user);
	
	public void delete(Integer userId);
	
	public void update(User user);
	
	public User getById(Integer userId);
	
	public Role findRoleByUserId(Integer userId);
	
	public User queryByUsername(String username);
}
