package com.stuman.dao.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.stuman.dao.SelectCourseDAO;
import com.stuman.dao.hibernate.HibernateUtil;
import com.stuman.domain.Courseinfo;
import com.stuman.domain.Selectcourse;

public class SelectCourseDAOImp implements SelectCourseDAO {

	private static Log log = LogFactory.getLog(SelectCourseDAOImp.class);
	public List<Selectcourse> listSelectCourseBySno(String sno) {
		try {
			// 获得Session
			Session s = HibernateUtil.currentSession();
			// 开始事务
			HibernateUtil.beginTransaction();
			// 执行操作
			List<Selectcourse> results = s.createQuery("from Selectcourse as cour where cour.id.sno=:stuNo").setString("stuNo", sno).list();
			// 提交事务
			HibernateUtil.commitTransaction();
			// 关闭Session
			HibernateUtil.closeSession();
			if (results != null ) {
				return results;
			}
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return null;
	}

	public List<Selectcourse> listSelectCourseByCno(String cno) {
		try {
			// 获得Session
			Session s = HibernateUtil.currentSession();
			// 开始事务
			HibernateUtil.beginTransaction();
			// 执行操作
			List<Selectcourse> results = s.createQuery("from Selectcourse as cour where cour.id.cno=:CourNo").setString("CourNo", cno).list();
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

	public int sumCreditBySno(String sno) {
		try
		{
		Session s = HibernateUtil.currentSession();
		// 开始事务
		HibernateUtil.beginTransaction();     
        Integer sum = (Integer)s.createQuery
        ("select sum(cour.score) from Selectcourse as cour  where cour.id.sno=:stuNo").setString("stuNo", sno).uniqueResult();
        HibernateUtil.commitTransaction();
		// 关闭Session
		HibernateUtil.closeSession();
		return sum.intValue();
		}
		catch (HibernateException e) {
			log.fatal(e);
		}
		return 0;//default
		
	}

	public boolean addSelectCourse(Selectcourse sltCourse) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			s.saveOrUpdate(sltCourse);
			System.out.println("add sltCourse cno =" + sltCourse.getId().getCno());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return false;
	}

	public boolean deleteSelectCourseById(String sno,String cno)
	{
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			Selectcourse cour = (Selectcourse) s.createQuery("from Selectcourse as cour where cour.id.cno=:CourNo"+" and cour.id.sno=:StuNo").setString("CourNo", cno).setString("StuNo", sno).uniqueResult();
			s.delete(cour);		
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return false;
	}

	public boolean updateSelectCourse(Selectcourse sltCourse) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			s.update(sltCourse);
			System.out.println("update SelectCourse cno =" + sltCourse.getId().getCno());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return false;
	}

}
