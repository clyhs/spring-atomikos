package org.sa.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.sa.bean.security.Resource;
import org.sa.security.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

@Service
public class MySecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource {
	
	private static boolean flag = false;

	@Autowired
	private ResourceService resourceService;

	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void reLoadResourceDefine(){
		flag = true;
		loadResourceDefine();
	}

	@PostConstruct
	private void loadResourceDefine() {
		System.err.println("-----------MySecurityMetadataSource loadResourceDefine ----------- ");
		if (resourceMap == null ) {
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			List<Resource> resources = resourceService.getAll();
			for (Resource resource : resources) {
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
				// TODO:ZZQ 通过资源名称来表示具体的权限 注意：必须"ROLE_"开头
				// 关联代码：applicationContext-security.xml
				// 关联代码：com.huaxin.security.MyUserDetailServiceImpl#obtionGrantedAuthorities
				ConfigAttribute configAttribute = new SecurityConfig("ROLE_"
						+ resource.getResKey());
				System.out.println(resource.getResKey());
				configAttributes.add(configAttribute);
				
				resourceMap.put(resource.getResUrl(), configAttributes);
			}
		}
		if(flag){
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			List<Resource> resources = resourceService.getAll();
			for (Resource resource : resources) {
				Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
				// TODO:ZZQ 通过资源名称来表示具体的权限 注意：必须"ROLE_"开头
				// 关联代码：applicationContext-security.xml
				// 关联代码：com.huaxin.security.MyUserDetailServiceImpl#obtionGrantedAuthorities
				ConfigAttribute configAttribute = new SecurityConfig("ROLE_"
						+ resource.getResKey());
				System.out.println(resource.getResKey());
				configAttributes.add(configAttribute);
				
				resourceMap.put(resource.getResUrl(), configAttributes);
			}
			flag = false;
		}
		
		System.err.println("-----------"+resourceMap.size()+" ----------- ");
		
	}

	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		
		System.err.println("-----------MySecurityMetadataSource getAttributes ----------- ");
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		System.out.println("requestUrl is " + requestUrl);
		if (resourceMap == null) {
			loadResourceDefine();
		}
		System.err.println("resourceMap.get(requestUrl); "
				+ resourceMap.get(requestUrl));
		if (requestUrl.indexOf("?") > -1) {
			requestUrl = requestUrl.substring(0, requestUrl.indexOf("?"));
		}
		Collection<ConfigAttribute> configAttributes = resourceMap
				.get(requestUrl);
		if (configAttributes == null) {
			Collection<ConfigAttribute> returnCollection = new ArrayList<ConfigAttribute>();
			returnCollection.add(new SecurityConfig("ROLE_USER"));
			return returnCollection;
		}
		return configAttributes;
	}

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

}
