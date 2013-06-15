package com.stuman.dao;

import java.util.List;
import com.stuman.domain.Courseinfo;

public interface CourseInfoDAO {
	List<Courseinfo> listCourseInfo();
	
	List<Courseinfo> listCourseInfoByDept(String deptName);
	
	Courseinfo getCourseInfoById(String id);
	
	boolean addCourseInfo(Courseinfo crInfo);
	
	boolean deleteCourseInfoById(String id);
	
	boolean updateCourseInfo(Courseinfo crInfo);
}