package com.stuman.web.jsf.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.stuman.dao.CourseDAO;
import com.stuman.dao.DAOFactory;
import com.stuman.dao.StudentDAO;
import com.stuman.domain.Course;
import com.stuman.domain.Student;
import com.stuman.dto.CourseDto;


public class StudentBean  {

	private StudentDAO stuDao;

	public StudentDAO getStudentDAO() {
		return DAOFactory.getInstance().createStudentDAO();
	}
	
	private DataModel dataModel = new ListDataModel();
	
	/**
	 * 新增学生业务逻辑
	 * @return
	 * @throws Exception
	 */
	public String addStudent() throws Exception{
		//获得DAO实例
		stuDao = this.getStudentDAO();

		Student stu = new Student();
		BeanUtils.copyProperties(stu, this);
		
		//调用DAO方法保存数据库
		if (stuDao.saveStudent(stu)) {
			return "success";
		}
		
		return null;
	}
	
	/**
	 * 管理员更新学生前读取数据
	 * @return
	 */
	public String preUpdateStudent(){
        this.student = (Student) dataModel.getRowData();
        StudentDAO stuDao = DAOFactory.getInstance().createStudentDAO();
		Student stu = stuDao.getStudentByID(student.getId());
		setStudent(stu);
		return "edit";
	}
	
	/**
	 * 管理员修改学生信息
	 * @return
	 */
	public String editStudentByAdmin(){
		
		//获得DAO实例
		stuDao = this.getStudentDAO();
		
		if(stuDao.updateStudent(getStudent())){
			return "success";
		}	
		
		return null;
	}
	
	public String delStudent(){
		//获得DAO实例
		stuDao = this.getStudentDAO();
		this.student = (Student) dataModel.getRowData();
		 
		if(stuDao.deleteStudentByID(student.getId())){
			return "success";
		}	
		
		return null;
	}
	/**
	 * 返回学生列表
	 * @return
	 */
    public DataModel getStudents() {
   		//获得DAO实例
   		stuDao = this.getStudentDAO();
   		List list = stuDao.getStudent();
   		dataModel.setWrappedData(list);
        return dataModel;
    }
    
    /**
	 * 预查看成绩
	 * @return
	 */
	public String preCheckMark(){

		//JSF获取session
		FacesContext context = FacesContext.getCurrentInstance(); 
		ExternalContext ec = context.getExternalContext(); 
		HttpSession session = (HttpSession) ec.getSession(true); 
		
		String stu_id = (String)session.getAttribute("stuid");
		System.out.println("Student_id = " + stu_id);
		StudentDAO stuDao = DAOFactory.getInstance().createStudentDAO();
		Student stu = stuDao.getStudentByID(stu_id);
		setStudent(stu);
		return "success";
	}
	
	
	 /**
	 * 预选修课程列表
	 * @return
	 */
	public DataModel getCourses(){		
		CourseDAO courseDao = DAOFactory.getInstance().createCourseDAO();
		CourseDto dto = new CourseDto();
		List<CourseDto> dtolist = new ArrayList<CourseDto>();
		dto.convert(courseDao.getCourse(), dtolist);
		dataModel.setWrappedData(dtolist);
		return dataModel;
	}
	
	
	 /**
	 * 学生更新信息前读取数据
	 * @return
	 */
	public String preModifyStudent(){

		//JSF获取session
		FacesContext context = FacesContext.getCurrentInstance(); 
		ExternalContext ec = context.getExternalContext(); 
		HttpSession session = (HttpSession) ec.getSession(true); 
		
		String stu_id = (String)session.getAttribute("stuid");
		System.out.println("Student_id = " + stu_id);
		StudentDAO stuDao = DAOFactory.getInstance().createStudentDAO();
		Student stu = stuDao.getStudentByID(stu_id);
		setStudent(stu);
		return "success";
	}
	
	
	
	private static final long serialVersionUID = 6563998465524859573L;

	private String id;

	private String name;

	private String password;

	private String jiguan;

	private String department;

	private String sex;

	private Integer mark;

	private String tel;

	private String phone;

	private String email;

	private String student_id;
	
	private Student student;
	
	private Course course;
	
	//在更新学生页面使用
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getStudent_id() {
		return student_id;
	}

	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJiguan() {
		return jiguan;
	}

	public void setJiguan(String jiguan) {
		this.jiguan = jiguan;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
