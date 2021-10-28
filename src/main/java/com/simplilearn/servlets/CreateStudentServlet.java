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

import com.simplilearn.entity.Students;
import com.simplilearn.entity.Subjects;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class createSubjectServlet
 */
public class CreateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("createStudent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("studentFirstName  : "+request.getParameter("studentFirstName"));
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction(); 
			Students std = new Students();
			//sub.setSubjectID((Integer)request.getParameter("subjectId"));
			std.setFirstName(request.getParameter("studentFirstName"));
			std.setLastName(request.getParameter("studentLastName"));
			std.setAge(Integer.parseInt(request.getParameter("studentAge")));
			std.setClassID(request.getParameter("studentClass"));
			//List<Subjects> subjectList = session.createQuery("from Subjects").getResultList();
			session.save(std);
			transaction.commit();
			//session.createQuery("from Subjects")
			PrintWriter out = response.getWriter();
			out.println("studentList" + std);
						

			List<Students> studentList = session.createQuery("from Students").getResultList();
			PrintWriter out1 = response.getWriter();
			out1.println("studentList" + studentList);
			

			List<HashMap<Object, Object>> studentsMapList = new ArrayList<>();
			for (Students student : studentList) {
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

}
