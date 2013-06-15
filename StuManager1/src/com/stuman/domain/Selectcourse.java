package com.stuman.domain;

/**
 * Selectcourse entity. @author MyEclipse Persistence Tools
 */

public class Selectcourse implements java.io.Serializable {

	// Fields

	private SelectcourseId id;
	private Integer score;
	private String teacher;

	// Constructors

	/** default constructor */
	public Selectcourse() {
	}

	/** minimal constructor */
	public Selectcourse(SelectcourseId id, String teacher) {
		this.id = id;
		this.teacher = teacher;
	}

	/** full constructor */
	public Selectcourse(SelectcourseId id, Integer score, String teacher) {
		this.id = id;
		this.score = score;
		this.teacher = teacher;
	}

	// Property accessors

	public SelectcourseId getId() {
		return this.id;
	}

	public void setId(SelectcourseId id) {
		this.id = id;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getTeacher() {
		return this.teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

}