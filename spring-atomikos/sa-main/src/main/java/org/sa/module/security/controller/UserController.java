package org.sa.module.security.controller;

import org.sa.bean.security.Role;
import org.sa.bean.security.User;
import org.sa.bean.security.UserRole;
import org.sa.security.service.RoleService;
import org.sa.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@RequestMapping("/module/security/user/index.html")
	@ResponseBody
	public String index()
	{
		return "user index";
	}

	@RequestMapping("/module/security/user/add.html")
	@ResponseBody
	public String add()
	{
		return "user add success";
	}
	
	@RequestMapping("/module/security/user/delete.html")
	@ResponseBody
	public String delete()
	{
		return "user delete success";
	}
	
	@RequestMapping("/module/security/user/query.json")
	@ResponseBody
	public User query(){
		//return userService.getById(1);
		return userService.queryByUsername("admin");
	}
	
	@RequestMapping("/module/security/user/selectuserrole.json")
	@ResponseBody
	public Role getRoleByUserId(){
		return userService.findRoleByUserId(1);
	}
	
	@RequestMapping("/module/security/user/adduserrole.html")
	@ResponseBody
	public String addUserRole()
	{
		UserRole userRole = new UserRole();
		userRole.setRoleId(1);
		userRole.setUserId(1);
		roleService.insertUserRole(userRole);
		return "role add success";
	}
	
	
}
