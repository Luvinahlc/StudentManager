package com.stuman.dao.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.stuman.dao.StudentDAO;
import com.stuman.dao.hibernate.HibernateUtil;
import com.stuman.domain.Student;

public class StudentDAOImp implements StudentDAO {

	private static Log log = LogFactory.getLog(StudentDAOImp.class);

	public List<Student> listStudent() {
		// TODO Auto-generated method stub
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			List<Student> results = s.createQuery("from Student stu").list();
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

	public boolean deleteStudentByID(String id) {
		// TODO Auto-generated method stub
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			Student stu = (Student) s.get(Student.class, id);
			
			s.delete(stu);
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;		
		} catch (HibernateException e) {
			log.fatal(e);
		}		
		return false;
	}

	public Student getStudentByID(String id) {
		// TODO Auto-generated method stub
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			Student stu = (Student) s.get(Student.class, id);
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return stu;		
		} catch (HibernateException e) {
			log.fatal(e);
		}		
		return null;
	}
	
	//new 
	public List<Student> listStudentByDept(String deptid) {
		// TODO Auto-generated method stub
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			List<Student> results = s.createQuery("from Student as stu where stu.sdept=:dept").setString("dept",deptid).list();
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
	// new 
	
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			s.update(student);
			System.out.println("update student sno =" + student.getSno());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;		
		} catch (HibernateException e) {
			log.fatal(e);
		}		
		return false;
	}

	public boolean addStudent(Student stu) {
		// TODO Auto-generated method stub
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();			
			s.saveOrUpdate(stu);
			System.out.println("save student sno =" + stu.getSno());
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			return true;		
		} catch (HibernateException e) {
			log.fatal(e);
		}		
		return false;
	}

	public List<Student> getStudentByGrade(String grade) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			List<Student> results = s.createQuery("from Student as stu where stu.grade=:sgrade").setString("sgrade",grade).list();
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

	public boolean isStuExist(String sno) {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			boolean isExsit = false;
			String str = new String();
			str = "from Student stu where stu.sno = '" +sno
					+ "'";
			Query query = s.createQuery(str);
			if (query.list().size() > 0) {
				isExsit=true;
			} 
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			if(isExsit==true)
				return true;
			else
				return false;
		} catch (HibernateException e) {
			HibernateUtil.commitTransaction();
			HibernateUtil.closeSession();
			e.printStackTrace();
		} 
		return false;
	}

	public List<String> getStudentGrade() {
		try {
			Session s = HibernateUtil.currentSession();
			HibernateUtil.beginTransaction();
			List<String> results = s.createQuery("select distinct stu.grade from Student as stu").list();
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
