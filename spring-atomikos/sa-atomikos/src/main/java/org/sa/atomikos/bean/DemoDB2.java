package org.sa.atomikos.bean;

import java.io.Serializable;

public class DemoDB2 implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String id;

    private String name;

    private Integer age;

    private String address;
    
    private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
