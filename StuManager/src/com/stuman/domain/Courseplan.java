package com.stuman.domain;

/**
 * Courseplan entity. @author MyEclipse Persistence Tools
 */

public class Courseplan implements java.io.Serializable {

	// Fields

	private String cno;
	private String ctime;
	private String cplace;
	private Integer type;
	private String teacher;
	private String examTime;
	private String examPlace;

	// Constructors

	/** default constructor */
	public Courseplan() {
	}

	/** minimal constructor */
	public Courseplan(Integer type) {
		this.type = type;
	}

	/** full constructor */
	public Courseplan(String ctime, String cplace, Integer type,
			String teacher, String examTime, String examPlace) {
		this.ctime = ctime;
		this.cplace = cplace;
		this.type = type;
		this.teacher = teacher;
		this.examTime = examTime;
		this.examPlace = examPlace;
	}

	// Property accessors

	public String getCno() {
		return this.cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getCtime() {
		return this.ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getCplace() {
		return this.cplace;
	}

	public void setCplace(String cplace) {
		this.cplace = cplace;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTeacher() {
		return this.teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getExamTime() {
		return this.examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getExamPlace() {
		return this.examPlace;
	}

	public void setExamPlace(String examPlace) {
		this.examPlace = examPlace;
	}
	public String getClassType(){
		switch (type){
		case 0: return "通修";
		case 1: return "通识";
		case 2: return "平台";
		case 3: return "核心";
		case 4: return "选修";
		default: return "";
		}
	}

}