package com.stuman.dao;

import com.stuman.dao.imp.AcademicDeanDAOImp;
import com.stuman.dao.imp.CourseInfoDAOImp;
import com.stuman.dao.imp.CoursePlanDAOImp;
import com.stuman.dao.imp.SelectCourseDAOImp;
import com.stuman.dao.imp.StudentDAOImp;
import com.stuman.dao.imp.UserDAOImp;

public abstract class DAOFactory {
	
	private static Object initLock = new Object();

	private static String className = "com.stuman.dao.imp.HibernateDAOFactory";

	private static DAOFactory factory = null;

	public static DAOFactory getInstance() {
		if (factory == null) {
			synchronized (initLock) {
				if (factory == null) {
					// Note, the software license expressely forbids
					// tampering with this check.
					// LicenseManager.validateLicense("Jive Forums Basic",
					// "2.0");

					String classNameProp = DAOConfig
							.getProperty("DAOFactory.className");
					if (classNameProp != null) {
						className = classNameProp;
					}
					try {
						// Load the class and create an instance.
						Class c = Class.forName(className);
						factory = (DAOFactory) c.newInstance();
					} catch (Exception e) {
						System.err.println("Failed to load DAOFactory class "
								+ className
								+ ". StuMan cannot function normally.");
						e.printStackTrace();
						return null;
					}
				}
			}
		}
		return factory;
	}

	public abstract StudentDAOImp createStudentDAOImp();
	public abstract UserDAOImp createUserDAOImp();
	public abstract AcademicDeanDAOImp createAcademicDeanDAOImp();
	public abstract CourseInfoDAOImp createCourseInfoDAOImp();
	public abstract CoursePlanDAOImp createCoursePlanDAOImp();
	public abstract SelectCourseDAOImp createSelectCourseDAOImp();

}
