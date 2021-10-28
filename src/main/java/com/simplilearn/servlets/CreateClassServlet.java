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

import com.simplilearn.entity.Classes;
import com.simplilearn.entity.Students;
import com.simplilearn.entity.Subjects;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class createSubjectServlet
 */
public class CreateClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateClassServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("createClass.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("class name   : "+request.getParameter("className"));
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction(); 
			Classes cls = new Classes();
			//sub.setSubjectID((Integer)request.getParameter("subjectId"));
			cls.setClassName(request.getParameter("className"));
			cls.setClassTeacherName(request.getParameter("classTeacherName"));
			cls.setStudentCount(Integer.parseInt(request.getParameter("studentCount")));
			
			//List<Subjects> subjectList = session.createQuery("from Subjects").getResultList();
			session.save(cls);
			transaction.commit();
			//session.createQuery("from Subjects")
			PrintWriter out = response.getWriter();
			out.println("studentList" + cls);
						

			List<Classes> classList = session.createQuery("from Classes").getResultList();
			PrintWriter out1 = response.getWriter();
			out1.println("classList" + classList);
			

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

}
