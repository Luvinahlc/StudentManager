package com.stuman.dao;

import java.util.List;

import com.stuman.domain.Classes;
import com.stuman.domain.Course;
import com.stuman.domain.Teacher;

public interface ClassesDAO {

	List getClasses();
	
	boolean deleteClassesByID(String id);
	boolean updateClasses(Classes cla);
	boolean saveClasses(Classes cla);
	
	Classes getClassesByID(String id);
	
	/**
	 * 根据课程查
	 * @param course
	 * @return
	 */
	Classes gerByCourse(Course course);
	
	/**
	 * 根据教师查
	 * @param teacher
	 * @return
	 */
	List<Classes> getByTea(Teacher teacher);
}
