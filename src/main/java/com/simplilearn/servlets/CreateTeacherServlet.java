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
import com.simplilearn.entity.Teachers;
import com.simplilearn.util.HibernateUtil;

/**
 * Servlet implementation class createSubjectServlet
 */
public class CreateTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getRequestDispatcher("createTeacher.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("teacher name : "+request.getParameter("teacherName"));
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
			Transaction transaction = session.beginTransaction(); 
			Teachers teacher = new Teachers();
			
			//teacher.setTeachersID(Integer.parseInt(request.getParameter("teachersId")));
			teacher.setTeachersName(request.getParameter("teacherName"));
			teacher.setClassTeacher(request.getParameter("classTeacher"));
			teacher.setSubject(request.getParameter("subject"));
			teacher.setAge(Integer.parseInt(request.getParameter("age")));
			teacher.setTeacherClasses(request.getParameter("teacherClasses"));
			
			session.save(teacher);
			transaction.commit();
			//session.createQuery("from Subjects")
			PrintWriter out = response.getWriter();
			out.println("teacherList" + teacher);
						

			List<Teachers> teacherList = session.createQuery("from Teachers").getResultList();
			PrintWriter out1 = response.getWriter();
			out1.println("teacherList" + teacherList);
			

			List<HashMap<Object, Object>> teachersMapList = new ArrayList<>();
			for (Teachers teachers : teacherList) {
				HashMap<Object, Object> teacherMap = new HashMap<>();
				
				teacherMap.put("teachersId", teachers.getTeachersID());
				
				teacherMap.put("teachersName", teachers.getTeachersName());
				
				teacherMap.put("classTeacher", teachers.getClassTeacher());
				
				teacherMap.put("teachersAge", teachers.getAge());
				
				teacherMap.put("teachersClasses", teachers.getTeacherClasses());
				
				teacherMap.put("subject", teachers.getSubject());
				
				teachersMapList.add(teacherMap);
			}
			JSONArray jsonArray = new JSONArray(teachersMapList);
			request.getRequestDispatcher("dashboard.jsp?teachers=" + jsonArray.toString()).forward(request, response);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
