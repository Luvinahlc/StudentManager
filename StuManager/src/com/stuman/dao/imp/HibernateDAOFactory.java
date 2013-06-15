package com.stuman.dao.imp;

import com.stuman.dao.*;

public class HibernateDAOFactory extends DAOFactory {

	public  StudentDAOImp createStudentDAOImp()
	{
		return new StudentDAOImp();
	}
	public UserDAOImp createUserDAOImp()
	{
		return new UserDAOImp();
	}
	public  AcademicDeanDAOImp createAcademicDeanDAOImp()
	{
		return new AcademicDeanDAOImp();
	}
	public  CourseInfoDAOImp createCourseInfoDAOImp()
	{
		return new CourseInfoDAOImp();
	}
	public CoursePlanDAOImp createCoursePlanDAOImp()
	{
		return new CoursePlanDAOImp();
	}
	public  SelectCourseDAOImp createSelectCourseDAOImp()
	{
		return new SelectCourseDAOImp();
	}
}
