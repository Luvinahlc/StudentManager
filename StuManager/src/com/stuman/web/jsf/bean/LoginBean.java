package com.stuman.web.jsf.bean;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.stuman.dao.hibernate.HibernateUtil;
import com.stuman.domain.User;


public class LoginBean {

	private static final long serialVersionUID = 1L;
	
	/**������ʾ��Ϣ**/
	private String msg;

	/** password property */
	private String password;

	/** username property */
	private String username;

	// --------------------------------------------------------- Methods
	public String login(){
		msg="";
		Session s = HibernateUtil.currentSession();
		
		//JSF��ȡsession
		FacesContext context = FacesContext.getCurrentInstance(); 
		ExternalContext ec = context.getExternalContext(); 
		HttpSession session = (HttpSession) ec.getSession(true); 
		
		//��������ĵ�½����
		username = getUsername();
		password = getPassword();
		try {
			HibernateUtil.beginTransaction();
			int identity = -1;
			String str = new String();
			str = "from User user where user.id = '" + username
					+ "' and user.password ='" + password + "'";
			System.out.println(str);
			Query query = s.createQuery(str);
			if (query.list().size() > 0) {
				session.setAttribute("id", ((User)query.list().get(0)).getId());
				identity =  ((User)query.list().get(0)).getIdentity();
				System.out.println(identity);
				s.close();
			} 

			switch (identity) {
				case 0:
					return "studentLoginsuccess";
				case 1:
					return "teacherLoginsuccess";
				case 2:
					return "adminLoginsuccess";
				default:
					break;
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			s.close();
		}
		msg="�û������벻ƥ��";
		return null;
	}

	/**
	 * Returns the password.
	 * 
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password.
	 * 
	 * @param password
	 *            The password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * Returns the username.
	 * 
	 * @return String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set the username.
	 * 
	 * @param username
	 *            The username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
