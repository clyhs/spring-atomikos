package org.sa.atomikos.db2.dao;

import java.util.List;

import org.sa.atomikos.bean.DemoDB1;
import org.sa.atomikos.bean.DemoDB2;
import org.sa.demo.bean.Demo;

public interface DemoDB2Mapper {

	int deleteByPrimaryKey(String id);

    int insert(DemoDB2 record);

    int insertSelective(DemoDB2 record);

    DemoDB2 selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(DemoDB2 record);

    int updateByPrimaryKey(DemoDB2 record);
    
    List<DemoDB2> getAll();
}
