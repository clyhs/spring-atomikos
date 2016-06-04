package org.sa.security.service;

import java.util.List;

import org.sa.bean.security.Resource;
import org.sa.bean.security.Role;
import org.sa.bean.security.RoleResource;
import org.sa.bean.security.UserRole;

public interface ResourceService {
	
    public List<Resource> getAll();
	
	public void insert(Resource resource);
	
	public void delete(Integer rescId);
	
	public void update(Resource resource);
	
	public Resource getById(Integer rescId);
	
    public void deleteRoleResource(Integer roleId);
	
	public void insertRoleResource(RoleResource roleResource);

}
