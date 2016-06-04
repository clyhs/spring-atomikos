package org.sa.security.service;

import java.util.List;

import org.sa.bean.security.Resource;
import org.sa.bean.security.RoleResource;
import org.sa.security.dao.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("resourceService")
public class ResourceServiceImpl implements ResourceService {

	@Autowired
	private ResourceMapper resourceMapper;
	
	public List<Resource> getAll() {
		// TODO Auto-generated method stub
		return resourceMapper.getAll();
	}

	public void insert(Resource resource) {
		// TODO Auto-generated method stub
		resourceMapper.insert(resource);
	}

	public void delete(Integer rescId) {
		// TODO Auto-generated method stub
		resourceMapper.delete(rescId);
	}

	public void update(Resource resource) {
		// TODO Auto-generated method stub
		resourceMapper.update(resource);
	}

	public Resource getById(Integer rescId) {
		// TODO Auto-generated method stub
		return resourceMapper.getById(rescId);
	}

	public void deleteRoleResource(Integer roleId) {
		// TODO Auto-generated method stub
		resourceMapper.deleteRoleResource(roleId);
	}

	public void insertRoleResource(RoleResource roleResource) {
		// TODO Auto-generated method stub
		resourceMapper.insertRoleResource(roleResource);
	}

}
