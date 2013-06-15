package com.stuman.web.jsf.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.stuman.dao.DAOFactory;
import com.stuman.dao.SelectCourseDAO;
import com.stuman.dao.StudentDAO;
import com.stuman.domain.Student;

public class StudentBean {
	
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
	
	private List students;
	
	private List courses;
	
	private String cno;

/*	public StudentBean() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance(); 
		ExternalContext ec = context.getExternalContext(); 
		HttpSession session = (HttpSession) ec.getSession(true); 
		
		String stu_id = (String)session.getAttribute("id");
		
		StudentDAO stuDao = getStudentDAO();
		Student stu = stuDao.getStudentByID(stu_id);
		
		BeanUtils.copyProperties(this, stu);
		
		System.out.println("id:"+getSno());
	}*/
	public StudentDAO getStudentDAO() {
		return DAOFactory.getInstance().createStudentDAOImp();
	}
	public SelectCourseDAO getSelectCourseDAO(){
		return DAOFactory.getInstance().createSelectCourseDAOImp();
	}
	
	public String CheckStuInfo() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance(); 
		ExternalContext ec = context.getExternalContext(); 
		HttpSession session = (HttpSession) ec.getSession(true); 
		
		String stu_id = (String)session.getAttribute("id");
		
		StudentDAO stuDao = getStudentDAO();
		Student stu = stuDao.getStudentByID(stu_id);
		
		BeanUtils.copyProperties(this, stu);
		
		System.out.println("id:"+getSno());
		
		return "success";	
	}
	
	public String modifyStuInfo() throws Exception {
		
		StudentDAO stuDao = getStudentDAO();
		Student stu=new Student();
		
		BeanUtils.copyProperties(stu, this);
		
		if(stuDao.updateStudent(stu)){
			return "success";
		}	
		
		return null;
	}
	
	public String listStudent() {
		
		StudentDAO stuDao = getStudentDAO();
		students = stuDao.listStudent();
		return "success";
	}
	
	public String GetSelectedCourses() {
		
		SelectCourseDAO selDao=getSelectCourseDAO();
		courses=selDao.listSelectCourseBySno(sno);		
		return "success";
	}
	
	public String DropCourse() {

		SelectCourseDAO selDao=getSelectCourseDAO();
		selDao.deleteSelectCourseById(sno, cno);	
		return "success";
	}
	
	public String getSno() {
		return sno;
	}
	
	public void setSno(String sno) {
		this.sno = sno;
	}
	
	public String getSname() {
		return sname;
	}
	
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getGender(){
		if(sgender==0)
			return "Å®";
		else
			return "ÄÐ";
	}
	public Integer getSgender() {
		return sgender;
	}
	
	public void setSgender(Integer sgender) {
		this.sgender = sgender;
	}
	
	public Date getSbirthday() {
		return sbirthday;
	}
	
	public void setSbirthday(Date sbirthday) {
		this.sbirthday = sbirthday;
	}
	
	public String getSidno() {
		return sidno;
	}
	
	public void setSidno(String sidno) {
		this.sidno = sidno;
	}
	
	public String getSdept() {
		return sdept;
	}
	public void setSdept(String sdept) {
		this.sdept = sdept;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public String getField() {
		return field;
	}
	
	public void setField(String field) {
		this.field = field;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public String getTutor() {
		return tutor;
	}
	
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	
	public Date getGraduationDate() {
		return graduationDate;
	}
	
	public void setGraduationDate(Date graduationDate) {
		this.graduationDate = graduationDate;
	}
	
	public String getDegree() {
		return degree;
	}
	
	public void setDegree(String degree) {
		this.degree = degree;
	}

	public List getStudents() {
		return students;
	}

	public void setStudents(List students) {
		this.students = students;
	}
}
