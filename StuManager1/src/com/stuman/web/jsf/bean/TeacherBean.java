package com.stuman.web.jsf.bean;

import java.util.HashSet;
import java.util.Set;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import com.stuman.dao.DAOFactory;
import com.stuman.dao.TeacherDAO;
import com.stuman.domain.Student;
import com.stuman.domain.Teacher;

public class TeacherBean {
	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8781453346180822209L;

	private String id;

	private String name;

	private String password;

	private String title;
	
	private DataModel dataModel=new ListDataModel();

	private Set classeses = new HashSet(0);
	
	private TeacherDAO stuDao;
	
	private Teacher teacher;

	


	public TeacherDAO getTeacherDAO() {
		return DAOFactory.getInstance().createTeacherDAO();
	}
	
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	/**
	 * 新增教师
	 * @return
	 */
	public String addTeacher(){
		stuDao = this.getTeacherDAO();
		Teacher stu = new Teacher();
		
		stu.setId(getId());
		stu.setName(getName());
		stu.setPassword( getPassword());
		stu.setTitle( getTitle());

		if (stuDao.saveTeacher(stu)) {
			return "success";
		}
		return null;
	}
	
	/**
	 * 教师列表
	 * @return
	 */
	public DataModel getTeachers(){
		stuDao = this.getTeacherDAO();
		dataModel.setWrappedData(stuDao.getTeacher());
		return dataModel;
	}
	
	
	/**
	 * 预编辑教师
	 * @return
	 */
	public String preEditTeacher(){
		Teacher teacher=(Teacher) dataModel.getRowData();
		stuDao = this.getTeacherDAO();
		setTeacher(stuDao.getTeacherByID(teacher.getId()));
		return "edit";
	}
	
	/**
	 * 编辑教师
	 * @return
	 */
	public String editTeacher(){
		stuDao = this.getTeacherDAO();
		if(stuDao.updateTeacher(getTeacher())){
			return "success";
		}
		return null;
	}
	
	/**
	 * 删除教师
	 * @return
	 */
	public String deleteTeacher(){
//		获得DAO实例
		stuDao = this.getTeacherDAO();
		this.teacher = (Teacher) dataModel.getRowData();
		if(stuDao.deleteTeacherByID(teacher.getId())){
			return "success";
		}	
		return null;
	}
	

	// Constructors

	/** default constructor */
	public TeacherBean() {
	}

	/** full constructor */
	public TeacherBean(String name, String password, String title, Set classeses) {
		this.name = name;
		this.password = password;
		this.title = title;
		this.classeses = classeses;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set getClasseses() {
		return this.classeses;
	}

	public void setClasseses(Set classeses) {
		this.classeses = classeses;
	}


	public Teacher getTeacher() {
		return teacher;
	}

}
