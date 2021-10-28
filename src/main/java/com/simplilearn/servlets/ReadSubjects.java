package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.security.auth.Subject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import com.simplilearn.entity.Students;
import com.simplilearn.entity.Subjects;
import com.simplilearn.entity.Teachers;
import com.simplilearn.util.HibernateUtil;

public class ReadSubjects extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadSubjects() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();

			List<Subjects> subjectList = session.createQuery("from Subjects").getResultList();
			PrintWriter out = response.getWriter();
			out.println("subjectList" + subjectList);
			

			List<HashMap<Object, Object>> subjectMapList = new ArrayList<>();
			for (Subjects subject : subjectList) {
				HashMap<Object, Object> subjectMap = new HashMap<>();
				
				subjectMap.put("subjectId", subject.getSubjectID());
				
				subjectMap.put("subject", subject.getSubject());
				
				subjectMap.put("subjectTeacher", subject.getSubjectTeachers());
				
				subjectMap.put("subjectClasses", subject.getSubjectClasses());
				
				subjectMapList.add(subjectMap);
			}
			JSONArray jsonArray = new JSONArray(subjectMapList);
			request.getRequestDispatcher("dashboard.jsp?subjects=" + jsonArray.toString()).forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
		
	}
}
