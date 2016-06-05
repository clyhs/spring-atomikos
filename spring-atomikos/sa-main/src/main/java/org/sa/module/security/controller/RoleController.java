package org.sa.module.security.controller;

import org.sa.bean.security.Role;
import org.sa.bean.security.RoleResource;
import org.sa.bean.security.User;
import org.sa.bean.security.UserRole;
import org.sa.security.service.ResourceService;
import org.sa.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private ResourceService resourceService;
	
	
	@RequestMapping("/module/security/role/index.html")
	@ResponseBody
	public String index()
	{
		return "role index";
	}
	
	@RequestMapping("/module/security/role/add.html")
	@ResponseBody
	public String add()
	{
		return "role add success";
	}
	
	@RequestMapping("/module/security/role/query.html")
	@ResponseBody
	public String query()
	{
		return "role query success";
	}
	
	@RequestMapping("/module/security/role/delete.html")
	@ResponseBody
	public String delete()
	{
		return "role delete success";
	}
	

	
}
