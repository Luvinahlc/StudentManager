package com.stuman.domain;

import java.util.HashSet;
import java.util.Set;

public class Classes implements java.io.Serializable {

	// Fields

	private String id;

	private Teacher teacher;

	private Course course;

	private String roomId;

	private String courTime;

	private Set enrols = new HashSet(0);

	// Constructors

	/** default constructor */
	public Classes() {
	}

	/** full constructor */
	public Classes(Teacher teacher, Course course, String roomId,
			String courTime, Set enrols) {
		this.teacher = teacher;
		this.course = course;
		this.roomId = roomId;
		this.courTime = courTime;
		this.enrols = enrols;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getRoomId() {
		return this.roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getCourTime() {
		return this.courTime;
	}

	public void setCourTime(String courTime) {
		this.courTime = courTime;
	}

	public Set getEnrols() {
		return this.enrols;
	}

	public void setEnrols(Set enrols) {
		this.enrols = enrols;
	}

}