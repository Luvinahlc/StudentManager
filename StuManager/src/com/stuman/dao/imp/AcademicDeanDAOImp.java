package com.stuman.dao.imp;

import java.util.List;

import com.stuman.dao.AcademicDeanDAO;
import com.stuman.dao.hibernate.HibernateUtil;
import com.stuman.domain.Academicdean;
import com.stuman.domain.Applyinfo;
import com.stuman.domain.Student;
import com.stuman.domain.Ungraduate;

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
			Academicdean academicdean = (Academicdean) s.get(Academicdean.class, id);
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
			Academicdean ad = (Academicdean) s.get(Academicdean.class, id);
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

	public List<Applyinfo> getApplyinfo() {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			List<Applyinfo> results = s.createQuery("from Applyinfo apply").list();
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

	public List<Applyinfo> getApplyinfoBySno(String sno) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			List<Applyinfo> results = s.createQuery("from Applyinfo as apply where apply.sno=:no").setString("no", sno).list();
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

	public List<Ungraduate> getUngraduateinfo() {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			List<Ungraduate> results = s.createQuery("from Ungraduate ungrad").list();
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

	public Ungraduate getUngraduateinfoBySno(String sno) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			Ungraduate result = (Ungraduate)(s.createQuery("from Ungraduate as ungrad where ungrad.sno=:no").setString("no", sno).uniqueResult());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			if (result != null ) {
				return result;
			}
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return null;
	}

}
