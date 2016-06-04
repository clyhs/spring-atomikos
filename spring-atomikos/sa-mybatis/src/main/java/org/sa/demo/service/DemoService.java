package org.sa.demo.service;

import java.util.List;

import org.sa.demo.bean.Demo;

public interface DemoService {


	List<Demo> getAll();
	
	Demo selectByPrimaryKey(String id);
	
    int insert(Demo muser);
    
    int update(Demo muser);
    
    int delete(String id);
}
