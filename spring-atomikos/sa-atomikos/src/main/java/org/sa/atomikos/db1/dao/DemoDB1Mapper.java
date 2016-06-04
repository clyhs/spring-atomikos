package org.sa.atomikos.db1.dao;

import java.util.List;

import org.sa.atomikos.bean.DemoDB1;
import org.sa.bean.demo.Demo;

public interface DemoDB1Mapper {

	int deleteByPrimaryKey(String id);

    int insert(DemoDB1 record);

    int insertSelective(DemoDB1 record);

    DemoDB1 selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DemoDB1 record);

    int updateByPrimaryKey(DemoDB1 record);
    
    List<DemoDB1> getAll();
}
