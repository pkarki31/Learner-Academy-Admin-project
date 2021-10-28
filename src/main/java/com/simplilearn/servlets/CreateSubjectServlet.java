package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.json.JSONArray;

import com.simplilearn.entity.Subjects;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class createSubjectServlet
 */
public class CreateSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSubjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("createSubject.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("subject id : "+request.getParameter("subjectId"));
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction(); 
			Subjects sub = new Subjects();
			//sub.setSubjectID((Integer)request.getParameter("subjectId"));
			sub.setSubject(request.getParameter("subjectName"));
			sub.setSubjectTeachers(request.getParameter("subjectTeacher"));
			sub.setSubjectClasses(request.getParameter("subjectClass"));
			//List<Subjects> subjectList = session.createQuery("from Subjects").getResultList();
			session.save(sub);
			transaction.commit();
			//session.createQuery("from Subjects")
			PrintWriter out = response.getWriter();
			out.println("subjectList" + sub);
						

			List<Subjects> subjectList = session.createQuery("from Subjects").getResultList();
			PrintWriter out1 = response.getWriter();
			out1.println("subjectList" + subjectList);
			

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

}
