package org.sa.module.security.controller;

import org.sa.bean.security.Role;
import org.sa.bean.security.User;
import org.sa.bean.security.UserRole;
import org.sa.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/module/security/role/add.html")
	@ResponseBody
	public String add()
	{
		Role role = new Role();
		
		role.setRoleId(1);
		role.setRolename("管理员");
		role.setRolecode("ROLE_ADMIN");
		roleService.insert(role);
		return "role add success";
	}
	
	
}
