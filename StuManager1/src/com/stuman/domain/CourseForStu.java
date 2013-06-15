package com.stuman.domain;

public class CourseForStu {
	private String id;
	private String name;
	private String prepare;
	private String dep;
	private String classid;
	private String roomid;
	private String time;
	private String teacher;
	public String getClassid() {
		return classid;
	}
	public void setClassid(String classid) {
		this.classid = classid;
	}
	public String getDep() {
		return dep;
	}
	public void setDep(String dep) {
		this.dep = dep;
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
	public String getPrepare() {
		return prepare;
	}
	public void setPrepare(String prepare) {
		this.prepare = prepare;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
