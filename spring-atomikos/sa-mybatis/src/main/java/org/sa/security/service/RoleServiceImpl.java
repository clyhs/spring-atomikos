package org.sa.security.service;

import java.util.List;

import org.sa.bean.security.Role;
import org.sa.bean.security.UserRole;
import org.sa.security.dao.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper;

	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return roleMapper.getAll();
	}

	public void insert(Role role) {
		// TODO Auto-generated method stub
		roleMapper.insert(role);
	}

	public void delete(Integer roleId) {
		// TODO Auto-generated method stub
		roleMapper.delete(roleId);
	}

	public void update(Role role) {
		// TODO Auto-generated method stub
		roleMapper.update(role);
	}

	public Role getById(Integer roleId) {
		// TODO Auto-generated method stub
		return (Role) roleMapper.getById(roleId);
	}

	public void deleteUserRole(Integer userId) {
		// TODO Auto-generated method stub
		roleMapper.deleteUserRole(userId);
	}

	public void insertUserRole(UserRole userRole) {
		// TODO Auto-generated method stub
		roleMapper.insertUserRole(userRole);
	}

}
