package com.stuman.dao;

import java.util.List;

import com.stuman.domain.Student;

public interface StudentDAO {
	
	List<Student> listStudent();//right
	
	boolean deleteStudentByID(String id);//right
	boolean updateStudent(Student stu);//right
	boolean addStudent(Student stu);//right	
	List<Student> listStudentByDept(String deptid);//right
	Student getStudentByID(String id);//right
	

}