package org.sa.security.dao;

import org.sa.base.BaseMapper;
import org.sa.bean.security.Resource;
import org.sa.bean.security.RoleResource;
import org.sa.bean.security.UserRole;

public interface ResourceMapper extends BaseMapper<Resource> {

    public void deleteRoleResource(Integer roleId);
	
	public void insertRoleResource(RoleResource roleResource);
	
}
