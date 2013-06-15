package com.stuman.dao.imp;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.stuman.dao.ClassesDAO;
import com.stuman.dao.hibernate.HibernateUtil;
import com.stuman.domain.Classes;
import com.stuman.domain.Course;
import com.stuman.domain.Teacher;

public class ClassesDAOImp implements ClassesDAO{

	private static Log log = LogFactory.getLog(ClassesDAOImp.class);

	//获得班级信息列表
	public List getClasses() {
		try {
			//获得Session
			Session s = HibernateUtil.currentSession();
			//开始事务
			HibernateUtil.beginTransaction();
			//执行操作
			List results = s.createQuery("from Classes cla").list();
			//提交事务
			HibernateUtil.commitTransaction();
			//关闭Session
			HibernateUtil.closeSession();
			//返回结果
			if (results != null && results.size() > 0) {
				return results;
			}
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return null;
	}

	//删除指定班级编号的班级信息
	public boolean deleteClassesByID(String id) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			Classes cla = (Classes) s.load(Classes.class, id);
			System.out.println(cla.getId());
			s.delete(cla);
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;		
		} catch (HibernateException e) {
			log.fatal(e);
		}		
		return false;
	}

	//通过班级编号获得班级信息
	public Classes getClassesByID(String id) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			Classes cla = (Classes) s.load(Classes.class, id);
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return cla;		
		} catch (HibernateException e) {
			log.fatal(e);
		}		
		return null;
	}

	//更新班级的信息
	public boolean updateClasses(Classes cla) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			s.update(cla);
			System.out.println("update Classes id =" + cla.getId());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;		
		} catch (HibernateException e) {
			log.fatal(e);
		}		
		return false;
	}

	//保存某班级的信息
	public boolean saveClasses(Classes cla) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();			
			s.saveOrUpdate(cla);
			System.out.println("save Classes id =" + cla.getId());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;		
		} catch (HibernateException e) {
			log.fatal(e);
		}		
		return false;
	}
	
	public Classes gerByCourse(Course course){
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			List<Classes> list =  s.createQuery("from Classes where course=:course")
			                       .setParameter("course", course).list();			
			if(list!=null&&list.size()>0){
				return list.get(0);	
			}			
		} catch (HibernateException e) {
			log.fatal(e);
		}finally{
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
		}
		return null;	
	}
	
	public List<Classes> getByTea(Teacher teacher){
		List<Classes> list = new ArrayList<Classes>();
		try {	
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			list =  s.createQuery("from Classes where teacher=:teacher")
			                       .setParameter("teacher", teacher).list();
				
		} catch (HibernateException e) {
			log.fatal(e);
		}finally{
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
		}
		return list;
	}
}
