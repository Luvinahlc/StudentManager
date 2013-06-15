package com.stuman.web.jsf.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.stuman.dao.AcademicDeanDAO;
import com.stuman.dao.DAOFactory;
import com.stuman.dao.StudentDAO;
import com.stuman.domain.Academicdean;
import com.stuman.domain.Applyinfo;
import com.stuman.domain.Student;
import com.stuman.domain.Ungraduate;

public class AcademicBean {
	
	private String ano;
	
	private String aname;
	
	private Integer agender;
	
	private Date abirthday;
	
	private String aidno;
	
	private String adept;

	private List<Applyinfo> applyinfo;
	
	private List<Ungraduate> ungraduate;
	
	private List<Student> students=new ArrayList<Student>();
	
	private Ungraduate ungrad;
	
	private List<String> grade;
	
	public AcademicDeanDAO getAcademicDeanDAO() {
		return DAOFactory.getInstance().createAcademicDeanDAOImp();
	}
	public StudentDAO getStudentDAO() {
		return DAOFactory.getInstance().createStudentDAOImp();
	}
	public boolean getApplyinformation(){
		AcademicDeanDAO acaDao = getAcademicDeanDAO();
		StudentDAO stuDao = getStudentDAO();
		applyinfo=acaDao.getApplyinfo();
		for(int i=0;i<applyinfo.size();i++){
			students.add((Student)stuDao.getStudentByID(applyinfo.get(i).getId().getSno()));
		}
		return true;
	}
	public boolean getStudentByGrade(String grade){
		StudentDAO stuDao = getStudentDAO();
		students=stuDao.getStudentByGrade(grade);
		return true;
	}
	public boolean getApplyinfoBySno(String sno){
		AcademicDeanDAO acaDao = getAcademicDeanDAO();
		applyinfo=acaDao.getApplyinfoBySno(sno);
		return true;
	}
	public boolean getUngraduateInformation(){
		AcademicDeanDAO acaDao = getAcademicDeanDAO();
		StudentDAO stuDao = getStudentDAO();
		ungraduate=acaDao.getUngraduateinfo();
		for(int i=0;i<ungraduate.size();i++){
			students.add((Student)stuDao.getStudentByID(ungraduate.get(i).getSno()));
		}
		return true;
	}
	public boolean getAllGrade(){
		StudentDAO stuDao = getStudentDAO();
		grade=stuDao.getStudentGrade();
		if(grade!=null)
			return true;
		return false;
	}
	public List<Applyinfo> getApplyinfo() {
		return applyinfo;
	}
	public List<Ungraduate> getUngraduate() {
		return ungraduate;
	}
	public List<Student> getStudent() {
		return students;
	}
	public boolean getUngraduateBySno(String sno){
		AcademicDeanDAO acaDao = getAcademicDeanDAO();
		ungrad=acaDao.getUngraduateinfoBySno(sno);
		if(ungrad==null)
			return false;
		return true;
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
	public List<String> getGrade() {
		return grade;
	}
	public void setGrade(List<String> grade) {
		this.grade = grade;
	}
	
}
