package org.sa.demo.dao;

import java.util.List;

import org.sa.bean.demo.Demo;

public interface DemoMapper {

	int deleteByPrimaryKey(String id);

    int insert(Demo record);

    int insertSelective(Demo record);

    Demo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Demo record);

    int updateByPrimaryKey(Demo record);
    
    List<Demo> getAll();
}
