package org.sa.security.dao;

import org.sa.base.BaseMapper;
import org.sa.bean.security.Role;
import org.sa.bean.security.User;

public interface UserMapper extends BaseMapper<User> {
	
    public int login(String username,String password);
	
	public User queryByUsername(String username);
	
	public Role findRoleByUserId(Integer userId);

}
