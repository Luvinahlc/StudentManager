package com.stuman.web.jsf.bean;

import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;

import com.stuman.dao.CourseInfoDAO;
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
	
	private String msg;
	
	public CoursePlanDAO getCoursePlanDAO(){
		return DAOFactory.getInstance().createCoursePlanDAOImp();
	}
	
	public CourseplanBean(){
		cno="0";
		ctime="0";
		cplace="0";
		type=0;
		teacher="0";
		examTime="0";
		examPlace="0";
		msg="";
		
	}
	public CoursePlanDAO getCourseplanDAO() {
		return DAOFactory.getInstance().createCoursePlanDAOImp();
	}
	public CourseInfoDAO getCourseinfoDAO(){
		return DAOFactory.getInstance().createCourseInfoDAOImp();
	}
	public boolean CheckCnoExist(){
		CourseInfoDAO courDao=getCourseinfoDAO();
		return courDao.isCourseExist(cno);
	}
	public boolean CheckCourseExist(){
		CoursePlanDAO courplanDao = getCourseplanDAO();
		return courplanDao.isCourseExist(cno);
	}
	public boolean addCoursePlan() throws Exception {
		
		Courseplan course = new Courseplan();
		
		BeanUtils.copyProperties(course, this);
		
		CoursePlanDAO crsplan = getCoursePlanDAO();
		
		if(crsplan.addCoursePlan(course))
			return true;
		
		return false;
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

	public void setCplace(String cplace) throws Exception {
		cplace=new String(cplace.getBytes("ISO-8859-1"),"utf8");
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

	public void setTeacher(String teacher) throws Exception {
		teacher=new String(teacher.getBytes("ISO-8859-1"),"utf8");
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

	public void setExamPlace(String examPlace) throws Exception {
		examPlace=new String(examPlace.getBytes("ISO-8859-1"),"utf8");
		this.examPlace = examPlace;
	}

	public List<Courseplan> getCourseplans() {
		return courseplans;
	}

	public void setCourseplans(List<Courseplan> courseplans) {
		this.courseplans = courseplans;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
