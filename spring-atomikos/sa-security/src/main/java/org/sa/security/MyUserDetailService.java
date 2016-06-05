package org.sa.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sa.bean.security.Resource;
import org.sa.bean.security.User;
import org.sa.security.service.ResourceService;
import org.sa.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service
public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserService userService;
	@Autowired
	private ResourceService resourceService;

	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userService.queryByUsername(username);
		if  (user==null)  
            throw new UsernameNotFoundException(username+" not exist!");
		Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(user);
		org.springframework.security.core.userdetails.User userdetail = new org.springframework.security.core.userdetails.User(
				user.getUsername(),
				user.getPassword(),
				true, 
				true, 
				true,
				true, 
				grantedAuths	//用户的权限
			);
		return userdetail;
	}

	// 取得用户的权限
	private Set<GrantedAuthority> obtionGrantedAuthorities(
			User user) {
		List<Resource> resources = resourceService.getUserResources(user.getUserId());
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		for (Resource res : resources) {
			// TODO:ZZQ 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
			// 关联代码：applicationContext-security.xml
			// 关联代码：com.huaxin.security.MySecurityMetadataSource#loadResourceDefine
			System.out.println(res.getResKey());
			authSet.add(new SimpleGrantedAuthority("ROLE_" + res.getResKey()));
		}
		return authSet;
	}
}
