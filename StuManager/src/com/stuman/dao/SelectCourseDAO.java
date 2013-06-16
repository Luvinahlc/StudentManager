package com.stuman.dao;

import java.util.List;

import com.stuman.domain.Scoreentertime;
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
	
	boolean setSelectTime(Selectcoursetime time);

	Selectcourse getSelectedCourseById(String sno, String cno);

	List<Selectcourse> listSelectCourse();
	
	boolean isSelectExist(String sno,String cno);
	
	boolean isSelectExist(String sno,String cno,String dept);
	
	boolean setScoreentertime(Scoreentertime time);
	
	Scoreentertime getScoreentertime();
}
