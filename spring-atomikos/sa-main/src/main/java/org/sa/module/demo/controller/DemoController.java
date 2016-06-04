package org.sa.module.demo.controller;

import javax.annotation.Resource;

import org.sa.demo.bean.Demo;
//import org.sa.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
	
//	@Resource(name="demoService")
//	//@Autowired
//	private DemoService demoService;
//	
//	@RequestMapping("/module/demo/demo.html")
//	@ResponseBody
//	public String hello(){
//		return "hello";
//	}
//	
//	@RequestMapping("/module/demo/add.html")
//	@ResponseBody
//	public String add(){
//		Demo muser = new Demo();
//		muser.setId("0000");
//		muser.setName("aaaa");
//		muser.setAge(1234);
//		muser.setAddress("ABCD");
//		int i = demoService.insert(muser);
//		return "hello add";
//	}

}
