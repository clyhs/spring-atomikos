package org.sa.module.security.controller;

import org.sa.bean.security.Resource;
import org.sa.bean.security.Role;
import org.sa.bean.security.User;
import org.sa.bean.security.UserRole;
import org.sa.security.service.ResourceService;
import org.sa.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ResourceController {

	@Autowired
	private ResourceService resourceService;
	
	@RequestMapping("/module/security/resource/add.html")
	@ResponseBody
	public String add()
	{
		Resource r = new Resource();
		
		r.setRescId(1);
		r.setName("用户管理");
		r.setpId(0);
		r.setType(0);
		r.setLevel(1);
		r.setResKey("sa_user");
		r.setResUrl("user");
		resourceService.insert(r);
		return "resource add success";
	}
	
	
}
