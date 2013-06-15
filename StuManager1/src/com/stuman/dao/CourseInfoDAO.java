package com.stuman.dao;

import java.util.List;
import com.stuman.domain.Courseinfo;

public interface CourseInfoDAO {
	List listCourseInfo();
	
	List listCourseInfoByDept(String deptName);
	
	Courseinfo getCourseInfoById(String id);
	
	boolean addCourseInfo(Courseinfo crInfo);
	
	boolean deleteCourseInfoById(String id);
	
	boolean updateCourseInfo(Courseinfo crInfo);
}