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
	 * ���ݿγ̲�
	 * @param course
	 * @return
	 */
	Classes gerByCourse(Course course);
	
	/**
	 * ���ݽ�ʦ��
	 * @param teacher
	 * @return
	 */
	List<Classes> getByTea(Teacher teacher);
}
