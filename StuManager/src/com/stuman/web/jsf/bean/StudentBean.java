package com.stuman.web.jsf.bean;

import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Session;

import com.stuman.dao.CourseInfoDAO;
import com.stuman.dao.CoursePlanDAO;
import com.stuman.dao.DAOFactory;
import com.stuman.dao.SelectCourseDAO;
import com.stuman.dao.StudentDAO;
import com.stuman.dao.hibernate.HibernateUtil;
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
	
	private String msg;
	
	private String cno;

	private int sum;
	
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
	
	public boolean modifyStuInfo() throws Exception {
		
		StudentDAO stuDao = getStudentDAO();
		Student stu=new Student(sname,sgender,sbirthday,sidno,sdept, major, field, grade,tutor,graduationDate,degree);
		stu.setSno(sno);
		
		//BeanUtils.copyProperties(stu, this);
		
		if(stuDao.updateStudent(stu)){
			return true;
		}	
		
		return false;
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
			if(courplan!=null){
				courses.add(cour);
				crs.add(courplan);
			}
		}
		return "success";
	}
	
	public String GetCoursesToBeChoosed() {
		CourseInfoDAO courDao=getCourseinfoDAO();
		CoursePlanDAO courplanDao = getCourseplanDAO();
		List<Courseinfo> sc=new ArrayList<Courseinfo>();
		sc=courDao.listCourseInfo();
		SelectCourseDAO selDao=getSelectCourseDAO();
		for(int i=0;i<sc.size();i++){
			if(!selDao.courseChoosed(sno, sc.get(i).getCno())){
				
				Courseplan courplan = courplanDao.getCoursePlanById(sc.get(i).getCno());
				if(courplan!=null){
					courses.add(sc.get(i));
					crs.add(courplan);
				}
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
	public String countCredit(String sno) {
		SelectCourseDAO selDao=getSelectCourseDAO();
		setSum(selDao.sumCreditBySno(sno));
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
	
	public void setSname(String sname) throws Exception{
		sname=new String(sname.getBytes("ISO-8859-1"),"utf8");
		this.sname = sname;
	}
	public String getGender(){
		if(sgender==null){
			return "";
		}
		if(sgender==0)
			return "女";
		else
			return "男";
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
	public void setSdept(String sdept) throws Exception {
		sdept=new String(sdept.getBytes("ISO-8859-1"),"utf8");
	this.sdept = sdept;
	}
	
	public String getMajor() {
		return major;
	}
	
	public void setMajor(String major) throws Exception {
		major=new String(major.getBytes("ISO-8859-1"),"utf8");
		this.major = major;
	}
	
	public String getField() {
		return field;
	}
	
	public void setField(String field) throws Exception {
		field=new String(field.getBytes("ISO-8859-1"),"utf8");
		this.field = field;
	}
	
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) throws Exception {
		grade=new String(grade.getBytes("ISO-8859-1"),"utf8");
		this.grade = grade;
	}
	
	public String getTutor() {
		return tutor;
	}
	
	public void setTutor(String tutor) throws Exception {
		tutor =new String(tutor .getBytes("ISO-8859-1"),"utf8");
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
	
	public void setDegree(String degree) throws Exception {

		degree =new String(degree .getBytes("ISO-8859-1"),"utf8");
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
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	private List<Student> studentsbydept=new ArrayList<Student>();
	private List<String > depnameList=new ArrayList<String>();
	
	public String listStudentbydept(String dept) throws Exception {
		StudentDAO stuDao = getStudentDAO();
		dept=new String(dept.getBytes("ISO-8859-1"),"utf8");
		studentsbydept = stuDao.listStudentByDept(dept);
		return "success";
	}
	public  String queryStuInfo(String sno) throws Exception
	{
		if(sno==null)this.setSno("");
		else{
			this.setSno(sno);
			if(this.checkStuExist()==true)
			{	
				
				this.CheckStuInfobyId(sno);
				this.setMsg("");
			}
			else
			{
				this.setMsg("该学生序号不存在");
				this.setSno("");
			}
		}
		return "success";
		
	}
	public List<Student> getdep()
	{
		return studentsbydept;
	}
	public String listdepname()
	{
		StudentDAO stuDao = getStudentDAO();
		List<Student> students = stuDao.listStudent();
		for(int i=0;i<students.size();i++)
		{
			String name=students.get(i).getSdept();
			System.out.println(name);
			depnameList.add(name);
		}
		 HashSet<String> h  =   new  HashSet<String>(depnameList); 
		 depnameList.clear(); 
		 depnameList.addAll(h);
		return "success";
	}
	public List<String> getdepname()
	{
		return depnameList;
	}
	
	private String dptname;
	
	public String getdptname()
	{
		return dptname;
	}
	public void setdptname(String dptname) throws Exception
	{
		dptname=new String(dptname.getBytes("ISO-8859-1"),"utf8");
		this.dptname=dptname;
	}
	
	private String msg_save;
	
	public String getmsg_save()
	{
		return msg_save;
	}
	public void setmsg_save(String msg_save)
	{
		this.msg_save=msg_save;
	}
	
	public StudentBean() {
		this.sno=" ";
		this.sname=" ";
		this.sgender=null;
		this.sbirthday=null;
		this.sidno=" ";
		this.sdept=" ";
		this.major=" ";
		this.field=" ";
		this.grade=" ";
		this.tutor=" ";	
		this.graduationDate=null;		
		this.degree=" ";		
		this.cno=" ";
		this.dptname="";
		this.msg="";
		this.msg_save="";
	}
	
	public String getStuNum()
	{
		if(getdep()==null)
			return "";
		int number=this.getdep().size();
		if(number==0)
		return "";
		else {
			return number+"";
		}
	}
	public boolean checkStuExist()
	{
		StudentDAO stuDao = getStudentDAO();
		return stuDao.isStuExist(sno);
	}
	public String CheckStuInfobyId(String sno) throws Exception {
		
		StudentDAO stuDao = getStudentDAO();
		Student stu = stuDao.getStudentByID(sno);
		
		BeanUtils.copyProperties(this, stu);
		sno=stu.getSno();
		sname=stu.getSname();
		sdept=stu.getSdept();
		major=stu.getMajor();
		field=stu.getField();
		grade=stu.getGrade();
		tutor=stu.getTutor();
		degree=stu.getDegree();
		sgender=stu.getSgender();
		sbirthday=stu.getSbirthday();
		sidno=stu.getSidno();
		graduationDate=stu.getGraduationDate();	
		System.out.println("id:"+getSno());
		
		return "success";	
	}
	public String getgraduationDate()
	{
		if(graduationDate==null)return "";
		else {
			return graduationDate.toString();
		}
	}
	public String getsbirthday()
	{
		if(sbirthday==null)return "";
		else {
			return sbirthday.toString();
		}
	}
}
