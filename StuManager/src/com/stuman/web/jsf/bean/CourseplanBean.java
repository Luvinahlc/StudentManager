package com.stuman.web.jsf.bean;

import java.util.List;
import org.apache.commons.beanutils.BeanUtils;

import com.stuman.dao.CoursePlanDAO;
import com.stuman.dao.DAOFactory;
import com.stuman.domain.Courseplan;

public class CourseplanBean {
	
	private String cno;
	
	private String ctime;
	
	private String cplace;
	
	private Integer type;
	
	private String teacher;
	
	private String examTime;
	
	private String examPlace;
	
	private List<Courseplan> courseplans;
	
	public CoursePlanDAO getCoursePlanDAO(){
		return DAOFactory.getInstance().createCoursePlanDAOImp();
	}
	
	public String updataCoursePlan() throws Exception {
		
		Courseplan course = new Courseplan();
		
		BeanUtils.copyProperties(course, this);
		
		CoursePlanDAO crsplan = getCoursePlanDAO();
		
		if(crsplan.updateCoursePlan(course))
			return "success";
		
		return null;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getCplace() {
		return cplace;
	}

	public void setCplace(String cplace) {
		this.cplace = cplace;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getExamTime() {
		return examTime;
	}

	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}

	public String getExamPlace() {
		return examPlace;
	}

	public void setExamPlace(String examPlace) {
		this.examPlace = examPlace;
	}

	public List<Courseplan> getCourseplans() {
		return courseplans;
	}

	public void setCourseplans(List<Courseplan> courseplans) {
		this.courseplans = courseplans;
	}
}
