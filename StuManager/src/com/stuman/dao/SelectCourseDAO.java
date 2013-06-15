package com.stuman.dao;

import java.util.List;

import com.stuman.domain.Selectcourse;
import com.stuman.domain.Selectcoursetime;

public interface SelectCourseDAO {

	List<Selectcourse> listSelectCourseBySno(String sno);
	
	List<Selectcourse> listSelectCourseByCno(String cno);
	
	int sumCreditBySno(String sno);//right
	
	boolean addSelectCourse(Selectcourse sltCourse);//right
	
	boolean deleteSelectCourseById(String sno,String cno);//right
	
	boolean updateSelectCourse(Selectcourse sltCourse);//right
	
	boolean courseChoosed(String sno, String cno);
	
	Selectcoursetime getSelectTime();
}
