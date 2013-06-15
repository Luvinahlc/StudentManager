package com.stuman.dao.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;


import com.stuman.dao.CourseInfoDAO;
import com.stuman.dao.hibernate.HibernateUtil;
import com.stuman.domain.Courseinfo;

public class CourseInfoDAOImp implements CourseInfoDAO{

	private static Log log = LogFactory.getLog(CourseInfoDAOImp.class);

	// 获得课程列表
	public List<Courseinfo> listCourseInfo() {
		try {
			// 获得Session
			Session s = HibernateUtil.currentSession();
			// 开始事务
			HibernateUtil.beginTransaction();
			// 执行操作
			List<Courseinfo> results = s.createQuery("from Courseinfo cour").list();
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

	public List<Courseinfo> listCourseInfoByDept(String deptName){
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			List<Courseinfo> results = s.createQuery("from Courseinfo as courinfo where courinfo.cdept =:DeptName").setString("DeptName", deptName).list();
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			if (results != null && results.size() > 0) {
				return results;
			}
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return null;
	}
	
	// 通过指定的课程编号删除课程信息
	public boolean deleteCourseInfoById(String id) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			Courseinfo cour = (Courseinfo) s.get(Courseinfo.class, id);
			System.out.println("delete Course info by id:"+cour.getCno());
			s.delete(cour);
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return false;
	}

	// 通过课程编号获得课程信息
	public Courseinfo getCourseInfoById(String id) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			Courseinfo cour = (Courseinfo) s.get(Courseinfo.class, id);
			
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return cour;
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return null;
	}

	// 更新课程信息
	public boolean updateCourseInfo(Courseinfo crInfo) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			s.update(crInfo);
			System.out.println("update Courseinfo cno =" + crInfo.getCno());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return false;
	}

	// 保存课程信息
	public boolean addCourseInfo(Courseinfo crInfo) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			s.saveOrUpdate(crInfo);
			System.out.println("add Course cno =" + crInfo.getCno());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return false;
	}
}