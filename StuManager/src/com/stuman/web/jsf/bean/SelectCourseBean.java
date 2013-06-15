package com.stuman.web.jsf.bean;

import java.util.List;

import com.stuman.domain.Selectcourse;

public class SelectCourseBean {
	private String sno;
	private String cno;
	private String teacher;
	private int score;
	private List<Selectcourse> courses;
	private int sumCredit;
	
	public String getCourseList() {
		return "success";
	}
	
	public String selectCourse() {
		return "success";
	}
	
	public String checkSelectedCourse() {
		return "success";
	}
	
	public String dropSelectedCourse() {
		return "success";
	}
	
	public String checkScore() {
		return "success";
	}
	
	public String checkScoreByCourse() {
		return "success";
	}
	
	public String sumCreditOfStu() {
		return "success";
	}
	
	public String inputScore() {
		return "success";
	}
	
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public List getCourses() {
		return courses;
	}
	public void setCourses(List courses) {
		this.courses = courses;
	}
	public int getSumCredit() {
		return sumCredit;
	}
	public void setSumCredit(int sumCredit) {
		this.sumCredit = sumCredit;
	}
	
	
	
}
