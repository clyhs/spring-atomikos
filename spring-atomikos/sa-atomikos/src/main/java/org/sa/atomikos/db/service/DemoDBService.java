package org.sa.atomikos.db.service;

import org.sa.atomikos.bean.DemoDB1;
import org.sa.atomikos.bean.DemoDB2;
import org.sa.atomikos.db1.service.DemoDB1Service;
import org.sa.atomikos.db2.service.DemoDB2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoDBService {

	@Autowired
	private DemoDB1Service demoDB1Service;
	
	@Autowired
	private DemoDB2Service demoDB2Service;
	
	@Transactional
	public void addDemo12(DemoDB1 d1,DemoDB2 db2){
		
		demoDB1Service.insert(d1);
		demoDB2Service.insert(db2);
		
	}
}
