package com.stuman.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.stuman.dao.EnrolDAO;
import com.stuman.dao.hibernate.HibernateUtil;
import com.stuman.domain.Classes;
import com.stuman.domain.Enrol;
import com.stuman.domain.EnrolId;
import com.stuman.domain.Score;
import com.stuman.domain.Student;

public class EnrolDAOImp implements EnrolDAO {

	private static Log log = LogFactory.getLog(EnrolDAOImp.class);

	public List getEnrol() {
		// TODO Auto-generated method enrob
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			List results = s.createQuery("from Enrol enro").list();
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

	public boolean deleteEnrolByID(EnrolId id) {
		// TODO Auto-generated method enrob
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();

			String classes_id = ((Classes) id.getClasses()).getId();
			String stu_id = ((Student) id.getStudent()).getId();
			// System.out.println("in deleteEnrolByID " + classes_id + " "
			// + stu_id);

			s.createQuery("delete com.stuman.domain.Enrol where class_id = '"
							+ classes_id
							+ "' and stu_id = '"
							+ stu_id
							+ "'");
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return false;
	}

	public Enrol getEnrolByID(String stuid, String classid) {
		// TODO Auto-generated method enrob
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();			
			Enrol enro = (Enrol)s.createQuery("from Enrol where class_id = '"
							+ classid
							+ "' and stu_id = '"
							+ stuid
							+ "'").list().get(0);
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return enro;
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return null;
	}

	public boolean updateEnrol(Enrol enro) {
		// TODO Auto-generated method enrob
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			s.update(enro);
			// System.out.println("update Enrol id =" + enro.getId());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return false;
	}

	public boolean saveEnrol(Enrol enro) {
		// TODO Auto-generated method enrob
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			// Enrol oldEenro = (Enrol) s.load(Enrol.class, id);
			s.saveOrUpdate(enro);
			// System.out.println("save Enrol id =" + enrob.getId());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return false;
	}

	public boolean addEnrol(String stuid, String classid) throws SQLException {
		// TODO Auto-generated method stub
		try {
			// 获得Session
			Session s = HibernateUtil.currentSession();
			// 执行操作
			Connection conn = s.connection();
			Statement sql = conn.createStatement();
			System.out.println("insert into enrol ( class_id, stu_id) values('"+classid+"','"+stuid+"')");
			sql.execute("insert into enrol ( class_id, stu_id) values('"+classid+"','"+stuid+"')");
			sql.close();
			// 关闭Session
			HibernateUtil.closeSession();
			
			return true;
			
		} catch (HibernateException e) {
			log.fatal(e);
		}
		return false;
	}

	public List getByStuId(String stuid) throws SQLException {
		// TODO Auto-generated method stub
		ArrayList results = new ArrayList();
		try {
			// 获得Session
			Session s = HibernateUtil.currentSession();
			// 执行操作
			Connection conn = s.connection();
			Statement sql = conn.createStatement();
			ResultSet rs = sql.executeQuery("select name, mark, score  from enrol,classes,course where stu_id = '"+stuid+"' and class_id = classes.id and course.id = classes.cour_id");
			while (rs.next()) {
				Score score = new Score();
				score.setCourse(rs.getString(1));
				score.setMark(rs.getString(2));
				score.setScore(rs.getString(3));
				results.add(score);
			}
			rs.close();
			sql.close();
			
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
	
	public List<Enrol> getByClasses(Classes classes){
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			List<Enrol> results = s.createQuery("from Enrol where accept='0' and classes=:classes")
			                       .setParameter("classes", classes).list();
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

}
