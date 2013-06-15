package com.stuman.dao;

import com.stuman.domain.Academicdean;

public interface AcademicDeanDAO {
	
	Academicdean getAcademicDeanById(String id);//right
	
	boolean addAcademicDean(Academicdean ad);//right
	
	boolean deleteAcademicDeanByID(String id);//right
	
	boolean updateAcademicDean(Academicdean ad);//right
	
}
