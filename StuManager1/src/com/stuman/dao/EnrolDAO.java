package com.stuman.dao;

import java.sql.SQLException;
import java.util.List;

import com.stuman.domain.Classes;
import com.stuman.domain.Enrol;
import com.stuman.domain.EnrolId;

public interface EnrolDAO {

	List getEnrol();
	List getByStuId(String stuid) throws SQLException;
	boolean addEnrol(String stuid, String classid) throws SQLException;
	boolean deleteEnrolByID(EnrolId id);
	boolean updateEnrol(Enrol enr);
	boolean saveEnrol(Enrol enr);
	
	Enrol getEnrolByID(String stuid, String classid);
	
	List<Enrol> getByClasses(Classes classes);
}
