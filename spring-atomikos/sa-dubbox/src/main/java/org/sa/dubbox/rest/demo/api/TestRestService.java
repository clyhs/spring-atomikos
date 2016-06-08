package org.sa.dubbox.rest.demo.api;

import org.sa.bean.demo.Test;
import org.sa.bean.security.User;

import javax.validation.constraints.Min;

public interface TestRestService {
	
	Test getTest(@Min(value=1L, message="User ID must be greater than 1") Long id/*, HttpServletRequest request*/);
	
	User getUser(Integer userId);

}
