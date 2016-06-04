package org.sa.security.dao;

import org.sa.base.BaseMapper;
import org.sa.bean.security.Role;
import org.sa.bean.security.UserRole;

public interface RoleMapper extends BaseMapper<Role> {

	public void deleteUserRole(Integer userId);
	
	public void insertUserRole(UserRole userRole);
}
