package org.sa.atomikos.db2.service;

import java.util.List;

import org.sa.atomikos.bean.DemoDB1;
import org.sa.atomikos.bean.DemoDB2;
import org.sa.demo.bean.Demo;

public interface DemoDB2Service {


	List<DemoDB2> getAll();
	
	DemoDB2 selectByPrimaryKey(String id);
	
    int insert(DemoDB2 muser);
    
    int update(DemoDB2 muser);
    
    int delete(String id);
}
