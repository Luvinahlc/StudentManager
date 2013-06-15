package com.stuman.web.jsf.bean;

import java.io.UnsupportedEncodingException;

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
	
	private String msg;
	
	public CourseInfoDAO getCourseInfoDAO(){
		return DAOFactory.getInstance().createCourseInfoDAOImp();
	}
	public CourseBean(){
		cno="0";
		cname="0";
		credit=0;
		hour=0;
		cdept="0";
		msg="";
	}
	
	public String checkCourseInfo() throws Exception {
		
		CourseInfoDAO crsDao = getCourseInfoDAO();
		
		Courseinfo crsinfo = new Courseinfo();
		
		crsinfo=crsDao.getCourseInfoById(cno);
		
		BeanUtils.copyProperties(this, crsinfo);
		
		return "success";	
	}
	public boolean CheckCourseExist(){
		CourseInfoDAO crsDao = getCourseInfoDAO();
		return crsDao.isCourseExist(cno);
	}
	public boolean addCourse() throws Exception {
		
		Courseinfo crsinfo = new Courseinfo();
		
		BeanUtils.copyProperties(crsinfo, this);
		
		CourseInfoDAO crsDao = getCourseInfoDAO();
		
		if(crsDao.addCourseInfo(crsinfo))
			return true;
		return false;
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
	public void setCname(String cname) throws Exception {
		cname=new String(cname.getBytes("ISO-8859-1"),"utf8");
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
	public void setCdept(String cdept) throws Exception {
		cdept=new String(cdept.getBytes("ISO-8859-1"),"utf8");
		this.cdept = cdept;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
