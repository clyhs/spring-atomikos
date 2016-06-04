package org.sa.atomikos.db2.service;

import java.util.List;

import org.sa.atomikos.bean.DemoDB1;
import org.sa.atomikos.bean.DemoDB2;
import org.sa.atomikos.db1.dao.DemoDB1Mapper;
import org.sa.atomikos.db2.dao.DemoDB2Mapper;
import org.sa.bean.demo.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("demoDB2Service")
public class DemoDB2ServiceImpl implements DemoDB2Service {

	private DemoDB2Mapper demoDB2Mapper;
	

	public DemoDB2Mapper getDemoDB2Mapper() {
		return demoDB2Mapper;
	}

	@Autowired
	public void setDemoDB2Mapper(DemoDB2Mapper demoDB2Mapper) {
		this.demoDB2Mapper = demoDB2Mapper;
	}

	public List<DemoDB2> getAll() {
		// TODO Auto-generated method stub
		return demoDB2Mapper.getAll();
	}

	public DemoDB2 selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return demoDB2Mapper.selectByPrimaryKey(id);
	}

	public int insert(DemoDB2 muser) {
		// TODO Auto-generated method stub
		return demoDB2Mapper.insert(muser);
	}

	public int update(DemoDB2 muser) {
		// TODO Auto-generated method stub
		return demoDB2Mapper.updateByPrimaryKey(muser);
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return demoDB2Mapper.deleteByPrimaryKey(id);
	}
	
	
	
	
}
