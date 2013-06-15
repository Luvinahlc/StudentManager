package com.stuman.domain;

import java.util.HashSet;
import java.util.Set;

public class Course implements java.io.Serializable {

	// Fields

	private String id;

	private String name;

	private Integer mark;

	private String prepare;

	private String dep;

	private Set classeses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** full constructor */
	public Course(String name, Integer mark, String prepare, String dep,
			Set classeses) {
		this.name = name;
		this.mark = mark;
		this.prepare = prepare;
		this.dep = dep;
		this.classeses = classeses;
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

	public Integer getMark() {
		return this.mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getPrepare() {
		return this.prepare;
	}

	public void setPrepare(String prepare) {
		this.prepare = prepare;
	}

	public String getDep() {
		return this.dep;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public Set getClasseses() {
		return this.classeses;
	}

	public void setClasseses(Set classeses) {
		this.classeses = classeses;
	}

}