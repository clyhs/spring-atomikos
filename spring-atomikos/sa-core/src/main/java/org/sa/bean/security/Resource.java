package org.sa.bean.security;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Resource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer rescId;
	
	private String name;
	
	private Integer pId;
	
	private Integer level;
	
	private Integer type;//0:目录 1:菜单 2：按键
	
	private String resKey;
	
	private String resUrl;
	
	private Set<Role> roles = new HashSet<Role>(0);
	
	private Set<Resource> childs = new HashSet<Resource>(0);

	

	public Integer getRescId() {
		return rescId;
	}

	public void setRescId(Integer rescId) {
		this.rescId = rescId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getResKey() {
		return resKey;
	}

	public void setResKey(String resKey) {
		this.resKey = resKey;
	}

	public String getResUrl() {
		return resUrl;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Resource> getChilds() {
		return childs;
	}

	public void setChilds(Set<Resource> childs) {
		this.childs = childs;
	}
	
	

}
