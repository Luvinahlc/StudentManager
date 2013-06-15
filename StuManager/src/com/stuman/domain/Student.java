package com.stuman.domain;

import java.util.Date;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	private String sno;
	private String sname;
	private Integer sgender;
	private Date sbirthday;
	private String sidno;
	private String sdept;
	private String major;
	private String field;
	private String grade;
	private String tutor;
	private Date graduationDate;
	private String degree;

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** full constructor */
	public Student(String sname, Integer sgender, Date sbirthday, String sidno,
			String sdept, String major, String field, String grade,
			String tutor, Date graduationDate, String degree) {
		this.sname = sname;
		this.sgender = sgender;
		this.sbirthday = sbirthday;
		this.sidno = sidno;
		this.sdept = sdept;
		this.major = major;
		this.field = field;
		this.grade = grade;
		this.tutor = tutor;
		this.graduationDate = graduationDate;
		this.degree = degree;
	}

	// Property accessors

	public String getSno() {
		return this.sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSgender() {
		return this.sgender;
	}

	public void setSgender(Integer sgender) {
		this.sgender = sgender;
	}

	public Date getSbirthday() {
		return this.sbirthday;
	}

	public void setSbirthday(Date sbirthday) {
		this.sbirthday = sbirthday;
	}

	public String getSidno() {
		return this.sidno;
	}

	public void setSidno(String sidno) {
		this.sidno = sidno;
	}

	public String getSdept() {
		return this.sdept;
	}

	public void setSdept(String sdept) {
		this.sdept = sdept;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getField() {
		return this.field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getTutor() {
		return this.tutor;
	}

	public void setTutor(String tutor) {
		this.tutor = tutor;
	}

	public Date getGraduationDate() {
		return this.graduationDate;
	}

	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

}