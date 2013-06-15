package com.stuman.domain;

import java.util.HashSet;
import java.util.Set;

public class Student implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5290815199794450572L;

	private String id;

	private String name;

	private String password;

	private String jiguan;

	private String department;

	private String sex;

	private Integer mark;

	private String tel;

	private String phone;

	private String email;

	private Set enrols = new HashSet(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String name, String password, String jiguan,
			String department, String sex, Integer mark, String tel,
			String phone, String email, Set enrols) {
		this.name = name;
		this.password = password;
		this.jiguan = jiguan;
		this.department = department;
		this.sex = sex;
		this.mark = mark;
		this.tel = tel;
		this.phone = phone;
		this.email = email;
		this.enrols = enrols;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJiguan() {
		return this.jiguan;
	}

	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getMark() {
		return this.mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set getEnrols() {
		return this.enrols;
	}

	public void setEnrols(Set enrols) {
		this.enrols = enrols;
	}

}