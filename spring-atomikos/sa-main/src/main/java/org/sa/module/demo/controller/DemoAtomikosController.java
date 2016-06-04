package org.sa.module.demo.controller;

import org.sa.atomikos.bean.DemoDB1;
import org.sa.atomikos.bean.DemoDB2;
import org.sa.atomikos.db.service.DemoDBService;
import org.sa.atomikos.db1.service.DemoDB1Service;
import org.sa.atomikos.db2.service.DemoDB2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.sql.DataSource;

@Controller
public class DemoAtomikosController  {
	
	@Autowired
	private DemoDB1Service demoDB1Service;
	
	@Autowired
	private DemoDB2Service demoDB2Service;
	
	@Autowired
	private DemoDBService demoDBService;
	
	
	@RequestMapping("/module/demoato/adddb1.html")
	@ResponseBody
	public String adddb1(){
		DemoDB1 muser = new DemoDB1();
		muser.setId("0000");
		muser.setName("aaaa");
		muser.setAge(1234);
		muser.setAddress("ABCD");
		int i = demoDB1Service.insert(muser);
		return "hello add db1";
	}
	
	@RequestMapping("/module/demoato/adddb2.html")
	@ResponseBody
	public String adddb2(){
		DemoDB2 muser = new DemoDB2();
		muser.setId("111");
		muser.setName("aaaa");
		muser.setAge(1234);
		muser.setAddress("ABCD");
		muser.setPassword("123");
		int i = demoDB2Service.insert(muser);
		return "hello add db2";
	}
	
	
	@RequestMapping("/module/demoato/add12.html")
	@ResponseBody
	public String adddb2anddb1(){
		
		
		DemoDB1 demo1 = new DemoDB1();
		demo1.setId("5555");
		demo1.setName("aaaa");
		demo1.setAge(1234);
		demo1.setAddress("ABCD");
		
		
		
		DemoDB2 muser = new DemoDB2();
		muser.setId("5555");
		muser.setName("aaaa");
		muser.setAge(1234);
		muser.setAddress("ABCD");
		muser.setPassword("34");
		try{
			demoDBService.addDemo12(demo1, muser);
		}catch(Exception e){
			
		}
		
		
		return "hello add db2 db1";
	}


}
