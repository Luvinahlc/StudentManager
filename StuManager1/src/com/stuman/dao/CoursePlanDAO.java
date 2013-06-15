package com.stuman.dao;

import java.util.List;

import com.stuman.domain.Courseplan;

public interface CoursePlanDAO {

	List listCoursePlan();//right
	
	Courseplan getCoursePlanById(String id);//right
	
	boolean addCoursePlan(Courseplan crPlan);//right
	
	boolean deleteCoursePlanById(String id);//right
	
	boolean updateCoursePlan(Courseplan crPlan);//right
}
