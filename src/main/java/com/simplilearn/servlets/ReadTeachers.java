package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import com.simplilearn.entity.Students;
import com.simplilearn.entity.Teachers;
import com.simplilearn.util.HibernateUtil;

public class ReadTeachers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadTeachers() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			List<Teachers> teachersList = session.createQuery("from Teachers").getResultList();
			PrintWriter out = response.getWriter();
			out.println("teachersList" + teachersList);
			

			List<HashMap<Object, Object>> teachersMapList = new ArrayList<>();
			for (Teachers teachers : teachersList) {
				HashMap<Object, Object> stduentMap = new HashMap<>();
				
				stduentMap.put("teachersId", teachers.getTeachersID());
				
				stduentMap.put("teachersName", teachers.getTeachersName());
				
				stduentMap.put("classTeacher", teachers.getClassTeacher());
				
				stduentMap.put("teachersAge", teachers.getAge());
				
				stduentMap.put("teachersClasses", teachers.getTeacherClasses());
				
				stduentMap.put("subject", teachers.getSubject());
				
				teachersMapList.add(stduentMap);
			}
			JSONArray jsonArray = new JSONArray(teachersMapList);
			request.getRequestDispatcher("dashboard.jsp?teachers=" + jsonArray.toString()).forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
