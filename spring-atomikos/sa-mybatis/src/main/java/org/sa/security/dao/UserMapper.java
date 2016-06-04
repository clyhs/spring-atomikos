package org.sa.security.dao;

import org.sa.base.BaseMapper;
import org.sa.bean.security.Role;

public interface UserMapper<User> extends BaseMapper {
	
    public int login(String username,String password);
	
	public User queryByUsername(String username);

}
