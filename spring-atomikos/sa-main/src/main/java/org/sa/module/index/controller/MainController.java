package org.sa.module.index.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sa.bean.demo.Test;
import org.sa.bean.security.RoleResource;
import org.sa.bean.security.User;
import org.sa.dubbox.demo.TestService;
import org.sa.security.MySecurityFilter;
import org.sa.security.MySecurityMetadataSource;
import org.sa.security.MyUserDetailService;
import org.sa.security.service.ResourceService;
import org.sa.security.service.UserService;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private AuthenticationManager myAuthenticationManager;
	@Autowired
	private MyUserDetailService myUserDetialService;
	
//	@Autowired
//	private TestService testService;
	
	@RequestMapping("/module/main/autologin.html")
	public String index(HttpServletRequest request){
		
		User user = new User();
		
		String username = "admin";
		user = userService.queryByUsername(username);
		
		Authentication authentication = myAuthenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username,user.getPassword()));
		SecurityContext securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(authentication);
		HttpSession session = request.getSession(true);  
	    session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);  
	    // 当验证都通过后，把用户信息放在session里
		request.getSession().setAttribute("userSession", user);
		
		return "redirect:/module/security/user/index.html";
	}
	
	@RequestMapping("/module/main/addrr.html")
	@ResponseBody
	public String addrr(HttpServletRequest request){
		
		RoleResource rr = new RoleResource();
		rr.setRescId(6);
		rr.setRoleId(1);
		resourceService.insertRoleResource(rr);
		
		User user = (User) request.getSession().getAttribute("userSession");
		
		ApplicationContext ctx =  WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
	    //FactoryBean factoryBean = (FactoryBean) ctx.getBean("mySecurityMetadataSource");
	    try {
	    	MySecurityMetadataSource fids= (MySecurityMetadataSource) ctx.getBean("mySecurityMetadataSource");;
	    	fids.reLoadResourceDefine();
			//fids = (FilterInvocationSecurityMetadataSource) factoryBean.getObject();
	    	MySecurityFilter filter = (MySecurityFilter) ctx.getBean("mySecurityFilter");
	    	
		    filter.setSecurityMetadataSource(fids);
		    
		    myUserDetialService.loadUserByUsername(user.getUsername());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
		
		return "success";
	}
	
//	@RequestMapping("/module/main/test.json")
//	@ResponseBody
//	public Test getTest(){
//		return testService.getTest(2l);
//	}
	

}
