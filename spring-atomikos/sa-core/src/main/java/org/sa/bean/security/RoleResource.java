package org.sa.bean.security;

import java.io.Serializable;

public class RoleResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer roleId;
	private Integer rescId;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getRescId() {
		return rescId;
	}
	public void setRescId(Integer rescId) {
		this.rescId = rescId;
	}

}
