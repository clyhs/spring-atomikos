package org.sa.module.security.controller;

import org.sa.bean.security.User;
import org.sa.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/module/security/user/add.html")
	@ResponseBody
	public String add()
	{
		User user = new User();
		user.setUserId(1);
		user.setUsername("admin");
		user.setPassword("123456");
		userService.insert(user);
		return "user add success";
	}
	
	@RequestMapping("/module/security/user/1.json")
	@ResponseBody
	public User getById(){
		return userService.getById(1);
	}
}
