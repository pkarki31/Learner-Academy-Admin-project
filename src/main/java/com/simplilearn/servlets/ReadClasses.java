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

import com.simplilearn.entity.Classes;
import com.simplilearn.util.HibernateUtil;

public class ReadClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadClasses() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			List<Classes> classList = session.createQuery("from Classes").getResultList();
			PrintWriter out = response.getWriter();
			out.println("classList" + classList);
			

			List<HashMap<Object, Object>> classMapList = new ArrayList<>();
			for (Classes classes : classList) {
				HashMap<Object, Object> classMap = new HashMap<>();
				
				classMap.put("classId", classes.getClassID());
				
				classMap.put("className", classes.getClassName());
				
				classMap.put("classTeacherName", classes.getClassTeacherName());
				
				classMap.put("classStudentCount", classes.getStudentCount());
				
				
				
			    classMapList.add(classMap);
			}
			JSONArray jsonArray = new JSONArray(classMapList);
			request.getRequestDispatcher("dashboard.jsp?classes=" + jsonArray.toString()).forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
