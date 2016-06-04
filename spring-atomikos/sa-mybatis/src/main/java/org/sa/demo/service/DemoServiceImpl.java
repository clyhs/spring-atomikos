package org.sa.demo.service;

import java.util.List;

import org.sa.demo.bean.Demo;
import org.sa.demo.dao.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("demoService")
public class DemoServiceImpl implements DemoService {

	private DemoMapper demoMapper;
	
	public DemoMapper getDemoMapper() {
		return demoMapper;
	}

	@Autowired
	public void setMuserMapper(DemoMapper demoMapper) {
		this.demoMapper = demoMapper;
	}

	public List<Demo> getAll() {
		// TODO Auto-generated method stub
		return demoMapper.getAll();
	}

	

	public int insert(Demo record) {
		// TODO Auto-generated method stub
		return demoMapper.insert(record);
	}

	public int update(Demo muser) {
		// TODO Auto-generated method stub
		return demoMapper.updateByPrimaryKey(muser);
	}

	public int delete(String id) {
		// TODO Auto-generated method stub
		return demoMapper.deleteByPrimaryKey(id);
	}

	public Demo selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return demoMapper.selectByPrimaryKey(id);
	}
	
	
}
