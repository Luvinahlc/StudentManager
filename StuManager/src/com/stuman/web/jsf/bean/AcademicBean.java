package com.stuman.web.jsf.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.stuman.dao.AcademicDeanDAO;
import com.stuman.dao.CourseInfoDAO;
import com.stuman.dao.CoursePlanDAO;
import com.stuman.dao.DAOFactory;
import com.stuman.dao.SelectCourseDAO;
import com.stuman.dao.StudentDAO;
import com.stuman.domain.Academicdean;
import com.stuman.domain.Applyinfo;
import com.stuman.domain.Courseinfo;
import com.stuman.domain.Courseplan;
import com.stuman.domain.Selectcourse;
import com.stuman.domain.Student;
import com.stuman.domain.Ungraduate;

public class AcademicBean {
	
	private String ano;
	
	private String aname;
	
	private Integer agender;
	
	private Date abirthday;
	
	private String aidno;
	
	private String adept;

	private List<Applyinfo> applyinfo=new ArrayList<Applyinfo>();
	
	private List<Ungraduate> ungraduate=new ArrayList<Ungraduate>();
	
	private List<String> grade;
	
	private Ungraduate ungrad;
	
	private String msg;
	
	private List<Student> stus = new ArrayList<Student>();
	
	private List<Courseinfo> courses = new ArrayList<Courseinfo>();
	
	private List<Selectcourse> scr = new ArrayList<Selectcourse>();
	
	private List<Courseplan> crs = new ArrayList<Courseplan>();
	
	private List<Student> students=new ArrayList<Student>();
	
	public AcademicDeanDAO getAcademicDeanDAO() {
		return DAOFactory.getInstance().createAcademicDeanDAOImp();
	}
	
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
	public String CheckAcdInfo() throws Exception {
		
		AcademicDeanDAO acdDao = getAcademicDeanDAO();
		Academicdean acd = acdDao.getAcademicDeanById(ano);
		
		BeanUtils.copyProperties(this, acd);
		ano = acd.getAno();
		aname = acd.getAname();
		aidno = acd.getAidno();
		adept = acd.getAdept();
		
		System.out.println("id:"+getAno());
		
		return "success";	
	}
	public String GetCourses() {
		SelectCourseDAO selDao=getSelectCourseDAO();
		CourseInfoDAO courDao=getCourseinfoDAO();
		CoursePlanDAO courplanDao = getCourseplanDAO();
		StudentDAO stuDao = getStudentDAO();

		courses.addAll(courDao.listCourseInfoByDept(adept));
		stus.addAll(stuDao.listStudentByDept(adept));
		
		for(int i = 0; i < courses.size(); i++){
			if(selDao.listSelectCourseByCno(courses.get(i).getCno()) != null){
				scr.addAll(selDao.listSelectCourseByCno(courses.get(i).getCno()));				
			}
			if(courplanDao.getCoursePlanById(courses.get(i).getCno()) != null){
				crs.add(courplanDao.getCoursePlanById(courses.get(i).getCno()));
			}
		}
		return "success";
	}

	public boolean getStudentByGrade(String grade){
		StudentDAO stuDao = getStudentDAO();
		students=stuDao.getStudentByGrade(grade);
		return true;
	}
	public boolean getStudentByGradeAndDept(String grade,String ano){
		AcademicDeanDAO acaDao = getAcademicDeanDAO();
		Academicdean aca = acaDao.getAcademicDeanById(ano);
		String dept=aca.getAdept();
		StudentDAO stuDao = getStudentDAO();
		students=stuDao.getStudentByGradeAndDept(grade, dept);
		return true;
	}
	public boolean getAllGrade(){
		StudentDAO stuDao = getStudentDAO();
		grade=stuDao.getStudentGrade();
		if(grade!=null)
			return true;
		return false;
	}
	public boolean getAllGradeByDept(String ano){
		AcademicDeanDAO acaDao = getAcademicDeanDAO();
		Academicdean aca = acaDao.getAcademicDeanById(ano);
		String dept=aca.getAdept();
		StudentDAO stuDao = getStudentDAO();
		grade=stuDao.getStudentGradeByDept(dept);
		if(grade!=null)
			return true;
		return false;
	} 

	public boolean getApplyinformation(String ano){
		AcademicDeanDAO acaDao = getAcademicDeanDAO();
		Academicdean aca = acaDao.getAcademicDeanById(ano);
		String dept=aca.getAdept();
		StudentDAO stuDao = getStudentDAO();
		List<Applyinfo> applyinfo=acaDao.getApplyinfo();
		for(int i=0;i<applyinfo.size();i++){
			Student stu=(Student)stuDao.getStudentByID(applyinfo.get(i).getId().getSno());
			if(stu.getSdept().equals(dept)){
				students.add(stu);
				this.applyinfo.add(applyinfo.get(i));
			}
		}
		return true;
	}
	public boolean getApplyinfoBySno(String sno){
		AcademicDeanDAO acaDao = getAcademicDeanDAO();
		applyinfo=acaDao.getApplyinfoBySno(sno);
		return true;
	}
	public boolean getUngraduateInformation(String ano){
		AcademicDeanDAO acaDao = getAcademicDeanDAO();
		Academicdean aca = acaDao.getAcademicDeanById(ano);
		String dept=aca.getAdept();
		StudentDAO stuDao = getStudentDAO();
		
		List<Ungraduate> ungraduate=new ArrayList<Ungraduate>();
		ungraduate=acaDao.getUngraduateinfo();
		for(int i=0;i<ungraduate.size();i++){
			Student stu=(Student)stuDao.getStudentByID(ungraduate.get(i).getSno());
			if(stu.getSdept().equals(dept)){
				students.add(stu);
				this.ungraduate.add(ungraduate.get(i));
			}
		}
		
		return true;
	}
	public List<Applyinfo> getApplyinfo() {
		return applyinfo;
	}
	public List<Ungraduate> getUngraduate() {
		return ungraduate;
	}
	public boolean getUngraduateBySno(String sno){
		AcademicDeanDAO acaDao = getAcademicDeanDAO();
		ungrad=acaDao.getUngraduateinfoBySno(sno);
		if(ungrad==null)
			return false;
		return true;
	}
	public boolean CheckCourseExist(String cno){
		CourseInfoDAO crsDao = getCourseinfoDAO();
		return crsDao.isCourseExist(cno);
	}
	public String CheckAcademicDean() throws Exception{		
		AcademicDeanDAO acaDao = getAcademicDeanDAO();
		Academicdean aca = acaDao.getAcademicDeanById(ano);
		
		BeanUtils.copyProperties(this, aca);
		
		System.out.println("id:"+getAno());
		
		return "success";	
	}

	public String modifyAcademicInfo() throws Exception {
		
		AcademicDeanDAO acaDao = getAcademicDeanDAO();
		
		Academicdean aca = new Academicdean();
		
		BeanUtils.copyProperties(aca, this);
		
		if(acaDao.updateAcademicDean(aca)){
			return "success";
		}	
		
		return null;
	}
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public Integer getAgender() {
		return agender;
	}
	public void setAgender(Integer agender) {
		this.agender = agender;
	}
	public Date getAbirthday() {
		return abirthday;
	}
	public List<String> getGrade() {
		return grade;
	}

	public void setGrade(List<String> grade) {
		this.grade = grade;
	}

	public void setAbirthday(Date abirthday) {
		this.abirthday = abirthday;
	}
	public String getAidno() {
		return aidno;
	}
	public void setAidno(String aidno) {
		this.aidno = aidno;
	}
	public String getAdept() {
		return adept;
	}
	public void setAdept(String adept) {
		this.adept = adept;
	}
	public Ungraduate getUngrad() {
		return ungrad;
	}
	public void setUngrad(Ungraduate ungrad) {
		this.ungrad = ungrad;
	}
	public void setApplyinfo(List<Applyinfo> applyinfo) {
		this.applyinfo = applyinfo;
	}
	public void setUngraduate(List<Ungraduate> ungraduate) {
		this.ungraduate = ungraduate;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Selectcourse> getSelectcourse(){
		return scr;
	}
	
	public List<Courseinfo> getCourseinfo(){
		return courses;
	}
	
	public List<Courseplan> getCourseplan(){
		return crs;
	}
	
	public void setMsg(String msg){
		this.msg = msg;
	}
	
	public String getMsg(){
		if(msg==null)
			return "";
		return msg;
	}

	public String ctimeBycno(String cno){
		if(cno != null){
			for(int i = 0; i < crs.size(); i++){
				if(crs.get(i).getCno().equals(cno))
					return crs.get(i).getCtime();
			}
		}
		return " ";
	}
	
	public String cplaceBycno(String cno){
		if(cno != null){
			for(int i = 0; i < crs.size(); i++){
				if(crs.get(i).getCno().equals(cno))
					return crs.get(i).getCplace();
			}
		}
		return " ";
	}
	
	public String eplaceBycno(String cno){
		if(cno != null){
			for(int i = 0; i < crs.size(); i++){
				if(crs.get(i).getCno().equals(cno))
					return crs.get(i).getCplace();
			}
		}
		return " ";
	}
	
	public String etimeBycno(String cno){
		if(cno != null){
			for(int i = 0; i < crs.size(); i++){
				if(crs.get(i).getCno().equals(cno))
					return crs.get(i).getCplace();
			}
		}
		return " ";
	}
	
	public boolean setPlanBycno(String cno, String cplace, String ctime, String eplace, String etime) throws Exception{
		if(cno != null){
			cplace = new String(cplace.getBytes("ISO-8859-1"),"utf8");
			ctime = new String(ctime.getBytes("ISO-8859-1"),"utf8");
			eplace = new String(eplace.getBytes("ISO-8859-1"),"utf8");
			etime = new String(etime.getBytes("ISO-8859-1"),"utf8");
			
			for(int i = 0; i < crs.size(); i++){
				if(crs.get(i).getCno().equals(cno)){
					crs.get(i).setCtime(ctime);
					crs.get(i).setCplace(cplace);
					if(eplace != null)
						crs.get(i).setExamPlace(eplace);
					if(etime != null)
						crs.get(i).setExamTime(etime);
					CoursePlanDAO crsplanDao = getCourseplanDAO();
					crsplanDao.updateCoursePlan(crs.get(i));
					return true;
				}
				
				
			}
			return false;
		}
		return false;
	}
	
	public String typeBycno(String cno){
		for(int i = 0; i < crs.size(); i++){
			if(crs.get(i).getCno().equals(cno))
				return crs.get(i).getClassType();
		}
		return " ";
	}
	
	public String teaBycno(String cno){
		for(int i = 0; i < crs.size(); i++){
			if(crs.get(i).getCno().equals(cno))
				return crs.get(i).getTeacher();
		}
		return " ";
	}

	public String snameBysno(String sno){
		for(int i = 0; i < crs.size(); i++){
			if(stus.get(i).getSno().equals(sno))
				return stus.get(i).getSname();
		}
		return "error";
	}
	
	public String gradeBysno(String sno){
		for(int i = 0; i < crs.size(); i++){
			if(stus.get(i).getSno().equals(sno))
				return stus.get(i).getGrade();
		}
		return "error";
	}
	public boolean addCourse(String cno,String cname,String credit,String type, String teacher) throws Exception{
		Courseinfo crsinfo = new Courseinfo();
		Courseplan crsplan = new Courseplan();
		
		cno = new String(cno.getBytes("ISO-8859-1"),"utf8");
		cname = new String(cname.getBytes("ISO-8859-1"),"utf8");
		credit = new String(credit.getBytes("ISO-8859-1"),"utf8");
		type = new String(type.getBytes("ISO-8859-1"),"utf8");
		teacher = new String(teacher.getBytes("ISO-8859-1"),"utf8");
		
		Integer temp = Integer.valueOf(credit);
		
		crsinfo.setCno(cno);
		crsinfo.setCname(cname);
		crsinfo.setCredit(temp);
		crsinfo.setHour(temp);
		crsinfo.setCdept(adept);
		crsplan.setCno(cno);
		crsplan.setTeacher(teacher);
		if(type.equals("通修"))
			temp = 0;
		if(type.equals("通识"))
			temp = 1;
		if(type.equals("平台"))
			temp = 2;
		if(type.equals("核心"))
			temp = 3;
		if(type.equals("选修"))
			temp = 4;		
		crsplan.setType(temp);
		
		CourseInfoDAO crsDao = getCourseinfoDAO();
		CoursePlanDAO crsplanDao = getCourseplanDAO();
		if(crsDao.addCourseInfo(crsinfo) && crsplanDao.addCoursePlan(crsplan))
			return true;
		return false;
	}
	
}
