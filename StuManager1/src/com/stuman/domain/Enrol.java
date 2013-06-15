package com.stuman.domain;

public class Enrol implements java.io.Serializable {

	// Fields

	private EnrolId id;

	private Classes classes;

	private Student student;

	private String accept;

	private String score;

	// Constructors

	/** default constructor */
	public Enrol() {
	}

	/** full constructor */
	public Enrol(String accept, String score) {
		this.accept = accept;
		this.score = score;
	}

	// Property accessors

	public EnrolId getId() {
		return this.id;
	}

	public void setId(EnrolId id) {
		this.id = id;
	}

	public Classes getClasses() {
		return this.classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getAccept() {
		return this.accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

}