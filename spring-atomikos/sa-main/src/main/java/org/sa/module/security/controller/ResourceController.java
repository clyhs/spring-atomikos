package org.sa.module.security.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	@RequestMapping("/module/security/resource/index.html")
	@ResponseBody
	public String index()
	{
		return "resource index";
	}
	
	@RequestMapping("/module/security/resource/add.html")
	@ResponseBody
	public String add()
	{

		return "resource add success";
	}
	
	@RequestMapping("/module/security/resource/query")
	@ResponseBody
	public List<Resource> query(HttpServletRequest request,HttpServletResponse response)
	{
		Integer userId = Integer.valueOf(request.getParameter("userid"));

		return resourceService.getUserResources(userId);
	}
	
	@RequestMapping("/module/security/resource/query2")
	@ResponseBody
	public List<Resource> query2(HttpServletRequest request,HttpServletResponse response)
	{
		String username = request.getParameter("username");

		return resourceService.getAll();
	}
	
	
}
