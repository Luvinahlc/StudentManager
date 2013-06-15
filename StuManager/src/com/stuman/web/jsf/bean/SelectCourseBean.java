package com.stuman.web.jsf.bean;

import java.util.*;
import java.sql.*;
import java.sql.Date;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.stuman.dao.CourseInfoDAO;
import com.stuman.dao.CoursePlanDAO;
import com.stuman.dao.DAOFactory;
import com.stuman.dao.SelectCourseDAO;
import com.stuman.dao.StudentDAO;
import com.stuman.dao.hibernate.HibernateUtil;
import com.stuman.domain.Courseinfo;
import com.stuman.domain.Courseplan;
import com.stuman.domain.Scoreentertime;
import com.stuman.domain.ScoreentertimeId;
import com.stuman.domain.Selectcourse;
import com.stuman.domain.SelectcourseId;
import com.stuman.domain.Selectcoursetime;
import com.stuman.domain.SelectcoursetimeId;
import com.stuman.domain.Student;

public class SelectCourseBean {
	private String sno;
	private String cno;
	private String teacher;
	private int score;
	private String startTime;
	private String endTime;
	private List<Selectcourse> courses=new ArrayList<Selectcourse>();
	private List<Courseinfo> courinfo=new ArrayList<Courseinfo>();
	private List<Courseplan> crs = new ArrayList<Courseplan>();
	
	private Selectcourse uniquecour;
	private int sumCredit;
	private String  msg="";
	
	public SelectCourseDAO getSelectCourseDAO(){
		return DAOFactory.getInstance().createSelectCourseDAOImp();
	}
	public StudentDAO getStudentDAO(){
		return DAOFactory.getInstance().createStudentDAOImp();
	}
	public CourseInfoDAO getCourseinfoDAO(){
		return DAOFactory.getInstance().createCourseInfoDAOImp();
	}
	public CoursePlanDAO getCourseplanDAO() {
		return DAOFactory.getInstance().createCoursePlanDAOImp();
	}
	public boolean setSelectTime() throws Exception{

		SelectcoursetimeId t=new SelectcoursetimeId();
		Selectcoursetime time=new Selectcoursetime();
		SelectCourseDAO selDao= getSelectCourseDAO();
		t.setStartTime(Date.valueOf(startTime));
		t.setEndTime(Date.valueOf(endTime));
		time.setId(t);
		if(selDao.setSelectTime(time))
			return true;
		return false;
		
	}
	public boolean checklist() {
		SelectCourseDAO selDao= getSelectCourseDAO();
		CourseInfoDAO courDao=getCourseinfoDAO();
		courses=selDao.listSelectCourseBySno(sno);
		int number=courses.size();
		for(int i=0;i<number;i++){
			Courseinfo cour=courDao.getCourseInfoById(courses.get(i).getId().getCno());
			courinfo.add(cour);
		}
		return true;
	}
	public boolean getScoreentertime(){
		ScoreentertimeId s=new ScoreentertimeId();
		Scoreentertime scoretime=new Scoreentertime();
		SelectCourseDAO selDao= getSelectCourseDAO();
		if(startTime!=null)
			s.setStartTime(Date.valueOf(startTime));
		if(endTime!=null)
			s.setEndTime(Date.valueOf(endTime));
		scoretime.setId(s);
		selDao.setScoreentertime(scoretime);
		return true;
	}
	public String getsname()
	{
		if(checkstuExist()==true)
		{
		StudentDAO stuDao=getStudentDAO();
		Student student=stuDao.getStudentByID(sno);
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
		StudentDAO stuDao=getStudentDAO();
		return stuDao.isStuExist(sno);
	}
	public boolean checkSelectExist(){
		SelectCourseDAO selDao= getSelectCourseDAO();
		return selDao.isSelectExist(sno, cno);
	}
	public String dropSelectedCourse(String sno,String cno) {
		SelectCourseDAO selDao= getSelectCourseDAO();
		selDao.deleteSelectCourseById(sno, cno);
		return "success";
	}
	public boolean ChooseCourse(String sno,String cno,String teacher){
		SelectCourseDAO selDao=getSelectCourseDAO();
		SelectcourseId courseid=new SelectcourseId(sno,cno); 
		Selectcourse sltCourse = new Selectcourse(courseid,teacher);
	
		if(selDao.addSelectCourse(sltCourse))
			return true;
		return false;
	}
	public boolean Modify(){
		SelectCourseDAO selDao= getSelectCourseDAO();
		uniquecour=selDao.getSelectedCourseById(sno,cno);
		uniquecour.setScore(score);
		selDao.updateSelectCourse(uniquecour);
		return true;
	}
	public String getCourseScore(){
		if(uniquecour==null){
		
			return "0";
		}
		else{
			return uniquecour.getScore().toString();
		}
	}
	public String checkCourse() {
		CourseInfoDAO courDao= getCourseinfoDAO();
		courinfo=courDao.listCourseInfo();
		
	//	System.out.println("course size:"+courses.size());
		return "success";
	}
	public String checkCoursePlan() {
		CoursePlanDAO courDao= getCourseplanDAO();
		crs=courDao.listCoursePlan();
		return "success";
	}
	public String getCourseList() {
		return "success";
	}
	
	public String selectCourse() {
		return "success";
	}
	
	public String checkSelectedCourse() {
		SelectCourseDAO selDao= getSelectCourseDAO();
		courses=selDao.listSelectCourse();
		return "success";
	}
	
	public String dropSelectedCourse() {
		return "success";
	}
	
	public String checkScore() {
		SelectCourseDAO selDao= getSelectCourseDAO();
		uniquecour=selDao.getSelectedCourseById(sno,cno);
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
		if(sno==null)
			return "0";
		return sno;
	}
	
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getCno() {
		if(cno==null)
			return "0";
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
	public List<Selectcourse> getCourses() {
		return courses;
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
	public List<Courseinfo> getCourinfo() {
		return courinfo;
	}
	public void setCourinfo(List<Courseinfo> courinfo) {
		this.courinfo = courinfo;
	}
	public List<Courseplan> getCrs() {
		return crs;
	}
	public void setCrs(List<Courseplan> crs) {
		this.crs = crs;
	}
	public Selectcourse getUniquecour() {
		return uniquecour;
	}
	public void setUniquecour(Selectcourse uniquecour) {
		this.uniquecour = uniquecour;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public void setCourses(List<Selectcourse> courses) {
		this.courses = courses;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
}
