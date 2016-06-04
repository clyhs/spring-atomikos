package org.sa.atomikos.db1.service;

import java.util.List;

import org.sa.atomikos.bean.DemoDB1;
import org.sa.demo.bean.Demo;

public interface DemoDB1Service {


	List<DemoDB1> getAll();
	
	DemoDB1 selectByPrimaryKey(String id);
	
    int insert(DemoDB1 muser);
    
    int update(DemoDB1 muser);
    
    int delete(String id);
}
