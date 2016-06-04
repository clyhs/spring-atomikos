package org.sa.atomikos.db1.service;

import java.util.List;

import org.sa.atomikos.bean.DemoDB1;
import org.sa.atomikos.db1.dao.DemoDB1Mapper;
import org.sa.bean.demo.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("demoDB1Service")
public class DemoDB1ServiceImpl implements DemoDB1Service {

	private DemoDB1Mapper demoDB1Mapper;
	
	

	public DemoDB1Mapper getDemoDB1Mapper() {
		return demoDB1Mapper;
	}

	@Autowired
	public void setDemoDB1Mapper(DemoDB1Mapper demoDB1Mapper) {
		this.demoDB1Mapper = demoDB1Mapper;
	}

	public List<DemoDB1> getAll() {
		// TODO Auto-generated method stub
		return demoDB1Mapper.getAll();
	}

	public DemoDB1 selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return demoDB1Mapper.selectByPrimaryKey(id);
	}

	public int insert(DemoDB1 muser) {
		// TODO Auto-generated method stub
		return demoDB1Mapper.insert(muser);
	}

	public int update(DemoDB1 muser) {
		// TODO Auto-generated method stub
		return demoDB1Mapper.updateByPrimaryKey(muser);
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return demoDB1Mapper.deleteByPrimaryKey(id);
	}
	
	
	
	
}
