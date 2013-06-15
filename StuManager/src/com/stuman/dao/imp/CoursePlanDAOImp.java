package com.stuman.dao.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.stuman.dao.CoursePlanDAO;
import com.stuman.dao.hibernate.HibernateUtil;
import com.stuman.domain.Courseplan;

public class CoursePlanDAOImp implements CoursePlanDAO {
	
	private static Log log = LogFactory.getLog(CoursePlanDAOImp.class);
	public List<Courseplan> listCoursePlan() {
		// TODO Auto-generated method stub
		try {
			// 获得Session
			Session s = HibernateUtil.currentSession();
			// 开始事务
			HibernateUtil.beginTransaction();
			// 执行操作
			List<Courseplan> results =s.createQuery("from Courseplan cour").list();
			
			// 提交事务
			HibernateUtil.commitTransaction();
			// 关闭Session
			HibernateUtil.closeSession();
			if (results != null && results.size() > 0) {
				return results;
			}
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return null;
	}


	public Courseplan getCoursePlanById(String id) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			Courseplan cour = (Courseplan) s.get(Courseplan.class, id);
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return cour;
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return null;
	}

	public boolean addCoursePlan(Courseplan crPlan){
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			s.saveOrUpdate(crPlan);
			System.out.println("add Courseplan cno =" + crPlan.getCno());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return false;
	}

	public boolean deleteCoursePlanById(String id){
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			Courseplan cour = (Courseplan) s.get(Courseplan.class, id);
			System.out.println(cour.getCno());
			s.delete(cour);
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return false;
	}

	public boolean updateCoursePlan(Courseplan crPlan) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			s.update(crPlan);
			System.out.println("update Course cno =" + crPlan.getCno());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return false;
	}

}
