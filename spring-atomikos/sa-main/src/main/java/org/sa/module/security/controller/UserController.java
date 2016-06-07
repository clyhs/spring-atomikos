package org.sa.module.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.sa.bean.security.Role;
import org.sa.bean.security.User;
import org.sa.bean.security.UserRole;
import org.sa.redis.RedisClient;
import org.sa.redis.RedisClientTemplate;
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
	
	@Autowired
	private RedisClient redisClient;
	
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
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setUserId(2);
		user.setUsername("333");
		users.add(user);
		
		redisClient.putArrayWithExpire("userlist", users, 10000);
		return "user add success";
	}
	
	@RequestMapping("/module/security/user/delete.html")
	@ResponseBody
	public String delete()
	{
		redisClient.deleteObjectByKey("user");
		return "delete ok";
	}
	
	@RequestMapping("/module/security/user/query.json")
	@ResponseBody
	public List<User> query(){
		//return userService.getById(1);
		return (List<User>) redisClient.getArrayWithExpire("userlist", User.class);
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
