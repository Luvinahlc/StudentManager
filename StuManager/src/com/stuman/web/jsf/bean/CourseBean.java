package com.stuman.web.jsf.bean;

import org.apache.commons.beanutils.BeanUtils;

import com.stuman.dao.CourseInfoDAO;
import com.stuman.dao.DAOFactory;
import com.stuman.domain.Courseinfo;


public class CourseBean {
	
	private String cno;
	
	private String cname;
	
	private Integer credit;
	
	private Integer hour;
	
	private String cdept;
	
	public CourseInfoDAO getCourseInfoDAO(){
		return DAOFactory.getInstance().createCourseInfoDAOImp();
	}
	
	public String checkCourseInfo() throws Exception {
		
		CourseInfoDAO crsDao = getCourseInfoDAO();
		
		Courseinfo crsinfo = new Courseinfo();
		
		crsinfo=crsDao.getCourseInfoById(cno);
		
		BeanUtils.copyProperties(this, crsinfo);
		
		return "success";	
	}
	
	public String addCourse() throws Exception {
		
		Courseinfo crsinfo = new Courseinfo();
		
		BeanUtils.copyProperties(crsinfo, this);
		
		CourseInfoDAO crsDao = getCourseInfoDAO();
		
		if(crsDao.addCourseInfo(crsinfo))
			return "success";
		return null;
	}
	
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}
	public String getCdept() {
		return cdept;
	}
	public void setCdept(String cdept) {
		this.cdept = cdept;
	}
	
	
}
