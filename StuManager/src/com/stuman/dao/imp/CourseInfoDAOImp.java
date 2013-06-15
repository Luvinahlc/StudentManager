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

	// ��ÿγ��б�
	public List<Courseinfo> listCourseInfo() {
		try {
			// ���Session
			Session s = HibernateUtil.currentSession();
			// ��ʼ����
			HibernateUtil.beginTransaction();
			// ִ�в���
			List<Courseinfo> results = s.createQuery("from Courseinfo cour").list();
			// �ύ����
			HibernateUtil.commitTransaction();
			// �ر�Session
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
	
	// ͨ��ָ���Ŀγ̱��ɾ���γ���Ϣ
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

	// ͨ���γ̱�Ż�ÿγ���Ϣ
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

	// ���¿γ���Ϣ
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

	// ����γ���Ϣ
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