package com.stuman.dao.imp;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.stuman.dao.UserDAO;
import com.stuman.dao.hibernate.HibernateUtil;
import com.stuman.domain.User;

public class UserDAOImp implements UserDAO {
	
	private static Log log = LogFactory.getLog(UserDAOImp.class);

	public boolean addUser(User user) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();			
			s.saveOrUpdate(user);
			System.out.println("save User id =" + user.getId());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;		
		} catch (HibernateException e) {
			log.fatal(e);
		}		
		return false;
	}

	public boolean deleteUserById(String id) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			User user = (User) s.load(User.class, id);
			System.out.println(user.getId());
			s.delete(user);
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;		
		} catch (HibernateException e) {
			log.fatal(e);
		}		
		return false;
	}

	public boolean updateUser(User user) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			s.update(user);
			System.out.println("update User id =" + user.getId());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;		
		} catch (HibernateException e) {
			log.fatal(e);
		}		
		return false;
	}

}