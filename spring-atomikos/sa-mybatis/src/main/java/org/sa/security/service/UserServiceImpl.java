package org.sa.security.service;

import java.util.List;

import org.sa.bean.security.User;
import org.sa.security.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userMapper.getAll();
	}

	public void insert(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
	}

	public void delete(Integer userId) {
		// TODO Auto-generated method stub
		userMapper.delete(userId);
	}

	public void update(User user) {
		// TODO Auto-generated method stub
		userMapper.update(user);
	}

	public User getById(Integer userId) {
		// TODO Auto-generated method stub
		return (User) userMapper.getById(userId);
	}

}
