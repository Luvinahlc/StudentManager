package com.stuman.web.jsf.bean;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.stuman.dao.DAOFactory;
import com.stuman.dao.SelectCourseDAO;
import com.stuman.dao.StudentDAO;
import com.stuman.dao.hibernate.HibernateUtil;
import com.stuman.domain.Selectcourse;
import com.stuman.domain.Student;

public class SelectCourseBean {
	private String sno;
	private String cno;
	private String teacher;
	private int score;
	private List<Selectcourse> courses;
	private int sumCredit;
	private String  msg="";
	
	public SelectCourseDAO getSelectCourseDAO(){
		return DAOFactory.getInstance().createSelectCourseDAOImp();
	}
	public StudentDAO getStudentDAO(){
		return DAOFactory.getInstance().createStudentDAOImp();
	}
	public String getsname()
	{
		if(checkstuExist()==true)
		{
		StudentDAO selDao=getStudentDAO();
		Student student=selDao.getStudentByID(sno);
		return student.getSname();
		}
		else return "";
	}
	
	public String getsno()
	{
		if(checkstuExist()==true)
		{
			return getSno();
		}
		else return "";
	}
	public boolean checkstuExist()
	
	{
		Session s = HibernateUtil.currentSession();
		String sno=getSno();
		try {
			HibernateUtil.beginTransaction();
			boolean isExsit = false;
			String str = new String();
			str = "from Student stu where stu.sno = '" +sno
					+ "'";
			Query query = s.createQuery(str);
			if (query.list().size() > 0) {
				isExsit=true;
				s.close();
			} 
			if(isExsit==true)
				return true;
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		return false;
	}
	
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
	public String getSumCredit() {
		
		if(checkstuExist()==true)
		{	
			SelectCourseDAO selDao=getSelectCourseDAO();
			sumCredit=selDao.sumCreditBySno(sno);
			return sumCredit+"";
		}
		else return "";
	}
	public void setSumCredit(int sumCredit) {
		this.sumCredit = sumCredit;
	}
	public String getmsg()
	{
		return msg;
	}
	public void setmsg(String msg)
	{
		this.msg=msg;
	}
}
