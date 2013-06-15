package com.stuman.dao.imp;

import java.util.List;

import com.stuman.dao.AcademicDeanDAO;
import com.stuman.dao.hibernate.HibernateUtil;
import com.stuman.domain.Academicdean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public class AcademicDeanDAOImp implements AcademicDeanDAO {

	private static Log log = LogFactory.getLog(AcademicDeanDAOImp.class);
	
	public Academicdean getAcademicDeanById(String id) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			Academicdean academicdean = (Academicdean) s.load(Academicdean.class, id);
			System.out.println("save academicedean ano:"+academicdean.getAno());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return academicdean;		
		} catch (HibernateException e) {
			log.fatal(e);
		}		
		return null;
	}

	public boolean addAcademicDean(Academicdean ad) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();			
			s.saveOrUpdate(ad);
			//System.out.println("save Academicdean ano =" + ad.getAno());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;		
		} catch (HibernateException e) {
			log.fatal(e);
		}		
		return false;
	}

	public boolean deleteAcademicDeanByID(String id) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			Academicdean ad = (Academicdean) s.load(Academicdean.class, id);
			System.out.println(ad.getAno());
			s.delete(ad);
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;		
		} catch (HibernateException e) {
			log.fatal(e);
		}		
		return false;
	}

	public boolean updateAcademicDean(Academicdean ad) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			s.update(ad);
			System.out.println("update Academicdean ano =" + ad.getAno());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;		
		} catch (HibernateException e) {
			log.fatal(e);
		}		
		return false;
	}

}
