package org.sa.dubbox.demo.impl;

import org.sa.bean.demo.Test;
import org.sa.bean.security.User;
import org.sa.dubbox.demo.TestService;

public class TestServiceImpl implements TestService {

	public Test getTest(Long id) {
		// TODO Auto-generated method stub
		return new Test(id,"clyhs");
	}

	public Long registerTest(Test test) {
		// TODO Auto-generated method stub
		return null;
	}

}
