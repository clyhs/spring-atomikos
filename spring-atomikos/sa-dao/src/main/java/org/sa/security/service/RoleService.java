package org.sa.security.service;

import java.util.List;

import org.sa.bean.security.Role;
import org.sa.bean.security.User;
import org.sa.bean.security.UserRole;

public interface RoleService {

    public List<Role> getAll();
	
	public void insert(Role role);
	
	public void delete(Integer roleId);
	
	public void update(Role role);
	
	public Role getById(Integer roleId);
	
	public void deleteUserRole(Integer userId);
	
	public void insertUserRole(UserRole userRole);
}
