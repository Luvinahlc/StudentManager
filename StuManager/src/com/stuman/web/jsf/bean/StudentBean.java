package com.stuman.web.jsf.bean;

import java.util.*;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.stuman.dao.CourseInfoDAO;
import com.stuman.dao.CoursePlanDAO;
import com.stuman.dao.DAOFactory;
import com.stuman.dao.SelectCourseDAO;
import com.stuman.dao.StudentDAO;
import com.stuman.domain.Courseinfo;
import com.stuman.domain.Courseplan;
import com.stuman.domain.Selectcourse;
import com.stuman.domain.SelectcourseId;
import com.stuman.domain.Selectcoursetime;
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
	
	private List<Student> students;
	
	private List<Courseinfo> courses=new ArrayList<Courseinfo>();
	
	private List<Courseplan> crs = new ArrayList<Courseplan>();
	
	private List<Integer> grades = new ArrayList<Integer>();
	
	
	private String cno;
	
	public StudentDAO getStudentDAO() {
		return DAOFactory.getInstance().createStudentDAOImp();
	}
	public SelectCourseDAO getSelectCourseDAO(){
		return DAOFactory.getInstance().createSelectCourseDAOImp();
	}
	public CourseInfoDAO getCourseinfoDAO(){
		return DAOFactory.getInstance().createCourseInfoDAOImp();
	}
	public CoursePlanDAO getCourseplanDAO() {
		return DAOFactory.getInstance().createCoursePlanDAOImp();
	}
	public boolean getSelectcourseTime(){
		SelectCourseDAO selDao=getSelectCourseDAO();
		Selectcoursetime time=selDao.getSelectTime();
		if (time == null)
			System.out.println("time is null!");
		Date now=new Date();
		System.out.println("today date:"+now);
		if(time==null)
			return false;
		if((time.getId().getStartTime().compareTo(now)<=0)&&(time.getId().getEndTime().compareTo(now)>=0))
			return true;
		return false;
	}
	public String CheckStuInfo() throws Exception {
		StudentDAO stuDao = getStudentDAO();
		Student stu = stuDao.getStudentByID(sno);
		
		BeanUtils.copyProperties(this, stu);
		sname=stu.getSname();
		sbirthday=stu.getSbirthday();
		sdept=stu.getSdept();
		field=stu.getField();
		major=stu.getMajor();
		tutor=stu.getTutor();
		graduationDate=stu.getGraduationDate();
		degree=stu.getDegree();
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
	public String ChooseCourse(String cno,String teacher){
		SelectCourseDAO selDao=getSelectCourseDAO();
		SelectcourseId courseid=new SelectcourseId(sno,cno); 
		Selectcourse sltCourse = new Selectcourse(courseid,teacher);
	
		selDao.addSelectCourse(sltCourse);
		return "success";
	}
	public String GetSelectedCourses() {
		
		SelectCourseDAO selDao=getSelectCourseDAO();
		CourseInfoDAO courDao=getCourseinfoDAO();
		CoursePlanDAO courplanDao = getCourseplanDAO();
		List<Selectcourse> sc=selDao.listSelectCourseBySno(sno);
		int number=sc.size();

		for(int i=0;i<number;i++){
			Courseinfo cour=courDao.getCourseInfoById(sc.get(i).getId().getCno());
			Courseplan courplan = courplanDao.getCoursePlanById(sc.get(i).getId().getCno());
			courses.add(cour);
			crs.add(courplan);
		}
		return "success";
	}
	
	public StudentBean() {
	}
	public String GetCoursesToBeChoosed() {
		CourseInfoDAO courDao=getCourseinfoDAO();
		CoursePlanDAO courplanDao = getCourseplanDAO();
		List<Courseinfo> sc=new ArrayList<Courseinfo>();
		sc=courDao.listCourseInfo();
		SelectCourseDAO selDao=getSelectCourseDAO();
		for(int i=0;i<sc.size();i++){
			if(!selDao.courseChoosed(sno, sc.get(i).getCno())){
				courses.add(sc.get(i));
				Courseplan courplan = courplanDao.getCoursePlanById(sc.get(i).getCno());
				crs.add(courplan);
			}
		}
		
		return "success";
	}
	
	public String getCourseGrades() {
		FacesContext context = FacesContext.getCurrentInstance(); 
		ExternalContext ec = context.getExternalContext(); 
		HttpSession session = (HttpSession) ec.getSession(true); 
		
		sno = (String)session.getAttribute("id");
		
		SelectCourseDAO selDao=getSelectCourseDAO();
		CourseInfoDAO courDao=getCourseinfoDAO();
		CoursePlanDAO courplanDao = getCourseplanDAO();
		List<Selectcourse> sc = selDao.listSelectCourseBySno(sno);
		int number = sc.size();

		for(int i=0;i<number;i++){
			Courseinfo cour = courDao.getCourseInfoById(sc.get(i).getId().getCno());
			Courseplan courplan = courplanDao.getCoursePlanById(sc.get(i).getId().getCno());
			courses.add(cour);
			crs.add(courplan);
			grades.add(sc.get(i).getScore());
		}
		return "success";
	}
	
	public List<Integer> getGrades() {
		return grades;
	}
	public void setGrades(List<Integer> grades) {
		this.grades = grades;
	}
	public List<Courseplan> getCrs() {
		return crs;
	}
	public void setCrs(List<Courseplan> crs) {
		this.crs = crs;
	}
	public String DropCourse() {

		SelectCourseDAO selDao=getSelectCourseDAO();
		selDao.deleteSelectCourseById(sno, cno);	
		return "success";
	}
	public String DropCourseByID(String cno){
		SelectCourseDAO selDao=getSelectCourseDAO();
		selDao.deleteSelectCourseById(sno, cno);
		return "success";	
	}
	public String getSno() {
		return sno;
	}
	
	public String getCno() {
		return cno;
	}
	public void setCno(String cno) {
		this.cno = cno;
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
	
<<<<<<< HEAD
	public void setDegree(String degree) throws Exception {

		degree =new String(degree .getBytes("ISO-8859-1"),"utf8");
=======
	public void setDegree(String degree) {
>>>>>>> 5e5c5985879fcd38cca9b1df0bf979028fec51ee
		this.degree = degree;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Courseinfo> getCourses() {
		return courses;
	}
	public void setCourses(List<Courseinfo> courses) {
		this.courses = courses;
	}

}
