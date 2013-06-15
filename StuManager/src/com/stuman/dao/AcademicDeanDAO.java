package com.stuman.dao;

import java.util.List;

import com.stuman.domain.Academicdean;
import com.stuman.domain.Applyinfo;
import com.stuman.domain.Ungraduate;

public interface AcademicDeanDAO {
	
	Academicdean getAcademicDeanById(String id);//right
	
	boolean addAcademicDean(Academicdean ad);//right
	
	boolean deleteAcademicDeanByID(String id);//right
	
	boolean updateAcademicDean(Academicdean ad);//right
	
	List<Applyinfo> getApplyinfo();
	
	List<Applyinfo> getApplyinfoBySno(String sno);
	
	List<Ungraduate> getUngraduateinfo();
	
	Ungraduate getUngraduateinfoBySno(String sno);
		
}
