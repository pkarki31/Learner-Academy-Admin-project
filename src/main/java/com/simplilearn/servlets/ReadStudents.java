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
import com.simplilearn.util.HibernateUtil;

public class ReadStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadStudents() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			List<Students> studentsList = session.createQuery("from Students").getResultList();
			PrintWriter out = response.getWriter();
			out.println("studentsList" + studentsList);
			

			List<HashMap<Object, Object>> studentsMapList = new ArrayList<>();
			for (Students student : studentsList) {
				HashMap<Object, Object> stduentMap = new HashMap<>();
				
				stduentMap.put("studentId", student.getStudentId());
				
				stduentMap.put("studentFirstName", student.getFirstName());
				
				stduentMap.put("studentLastName", student.getLastName());
				
				stduentMap.put("studentAge", student.getAge());
				
				stduentMap.put("studentClass", student.getClassID());
				
				studentsMapList.add(stduentMap);
			}
			JSONArray jsonArray = new JSONArray(studentsMapList);
			request.getRequestDispatcher("dashboard.jsp?students=" + jsonArray.toString()).forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
