package com.stuman.dao;

import java.util.List;

import com.stuman.domain.Selectcourse;

public interface SelectCourseDAO {

	List listSelectCourseBySno(String sno);
	
	List listSelectCourseByCno(String cno);
	
	int sumCreditBySno(String sno);//right
	
	boolean addSelectCourse(Selectcourse sltCourse);//right
	
	boolean deleteSelectCourseById(String sno,String cno);//right
	
	boolean updateSelectCourse(Selectcourse sltCourse);//right
}
