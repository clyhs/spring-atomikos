package org.sa.dubbox.rest.demo.api.impl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import com.alibaba.dubbo.rpc.protocol.rest.support.ContentType;

import org.sa.bean.demo.Test;
import org.sa.bean.security.User;
import org.sa.dubbox.demo.TestService;
import org.sa.dubbox.rest.demo.api.TestRestService;
import org.sa.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@Path("test")
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
@Produces({ContentType.APPLICATION_JSON_UTF_8, ContentType.TEXT_XML_UTF_8})
public class TestRestServiceImpl implements TestRestService {
	
	private TestService testService;
	
	@Autowired
	private UserService userService;

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	@GET
    @Path("{id : \\d+}")
	public Test getTest(@PathParam("id") Long id/*, @Context HttpServletRequest request*/) {
		// TODO Auto-generated method stub
		return testService.getTest(1l);
	}

	@GET
    @Path("user/{id : \\d+}")
	public User getUser(@PathParam("id") Integer id) {
		// TODO Auto-generated method stub
		return userService.getById(1);
	}

}
