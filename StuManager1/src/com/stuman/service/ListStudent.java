package com.stuman.service;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;

import com.stuman.dao.DAOFactory;
import com.stuman.dao.StudentDAO;
import com.stuman.domain.Student;
import com.sun.faces.taglib.html_basic.CommandButtonTag;

public class ListStudent {

	private StudentDAO stuDao;

	public StudentDAO getStudentDAO() {
		return DAOFactory.getInstance().createStudentDAO();
	}

	// 异常还没有处理
	public void list(HttpServletRequest request, JspWriter out)
			throws Exception {
		String tmp = (String) request.getParameter("page");

		if (tmp != null) {
			listpage(request, out, Integer.parseInt(tmp));
		} else {
			listpage(request, out, 1);
		}
	}

	public void listpage(HttpServletRequest request, JspWriter out, int page)
			throws Exception {

		String name = "", id = "", password = "", jiguan = "", dep = "", sex = "", tel = "", mail = "", mark = "";
		stuDao = this.getStudentDAO();
		List list = stuDao.getStudent();

		if (list == null) {
			out.print("尚无学生信息");
			return;
		}

		int total = list.size();
		int count = 0;
		Iterator it = list.iterator();
		Student stu;
		// User user;
		// OrderItem item;
		// Flight flight;

		while (count < (page - 1) * 5 && it.hasNext()) {
			it.next();
			count++;
		}

		count = 0;
		
		while (it.hasNext() && count < 5) {
			stu = (Student) it.next();

			id = stu.getId();
			name = stu.getName();
			password = stu.getPassword();
			jiguan = stu.getJiguan();
			dep = stu.getDepartment();
			sex = stu.getSex();
			if( stu.getMark() != null )
				mark = stu.getMark().toString();
			tel = stu.getTel();
			if (tel == null || tel.equals(""))
				tel = "无";
			mail = stu.getEmail();
			if (mail == null || mail.equals(""))
				mail = "无";

			out.print("<tr><td>" + id + "</td><td>" + name + "</td><td>"
					+ password + "</td><td>" + jiguan + "</td><td>" + dep
					+ "</td><td>" + sex + "</td><td>" + mark + "</td><td>"
					+ tel + "</td><td>" + mail + "</td>");
			out.print("<td><a href=deleteStudent.do?student_id="
					+ stu.getId() + ">删除</a></td><td>");
			CommandButtonTag cbuttonTag = new CommandButtonTag();
			cbuttonTag.setAction("#{studentBean.preUpdateStudent}");
			cbuttonTag.doStartTag();
			out.print("修改");
			cbuttonTag.doEndTag();
			out.print("<a href=updatestu.faces?student_id="
					+ stu.getId() + ">编辑</a></td></tr>");

			count++;
		}
		out.print("<tr><td colspan=5 align=center>");
		out.print("<table width=50% border=0 cellspacing=0><tr>");
		if ((page - 1) > 0)
			out
					.print("<td width=50% colspan='5'> <a href=getStudent.jsp?page="
							+ (page - 1) + ">上一页</a>　&nbsp;&nbsp;&nbsp;&nbsp;");
		else
			out.print("<td width=50% colspan='5'>上一页</td>");
		if ((page - 1) < (total / 5))
			out.print("<td width=50% colspan='5'><a href=getStudent.jsp?page="
					+ (page + 1) + ">下一页</a></td>");
		else
			out.print("<td width=50%  colspan='5'>下一页</td>");
		out.print("</tr></table></td></tr>");
		out.print("</table>");
	}

}
