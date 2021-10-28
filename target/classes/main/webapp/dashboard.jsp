<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.Objects"%>
<%@page import="java.util.List"%>
<%@page import="com.fasterxml.jackson.databind.ObjectMapper"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		String usernameSession = (String) session.getAttribute("username");
		if (session.getAttribute("username") == null) {
			response.sendRedirect("invalid.jsp?error=1");
		}
	%>
	<div class="container mt-3">
		<h2>Welcome to Geeta International School </h2>
		  <a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
		  <a href="students"> <button class="btn btn-primary">View Students</button></a>
		  <a href="teachers"> <button class="btn btn-primary">View Teachers</button></a>
		  <a href="subjects"> <button class="btn btn-primary">View Subjects</button></a>
		  <a href="classes"> <button class="btn btn-primary">View Classes</button></a>
		  
		<%
			String students = request.getParameter("students");
			if (Objects.nonNull(students)) {

				%>
				<p>List of Students</p>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Student Age</th>
							<th>Class</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<HashMap<Object, Object>> studentsList = new ObjectMapper().readValue(students, List.class);
		
								for (HashMap<Object, Object> eachMap : studentsList) {
									int studentId = (Integer) eachMap.get("studentId");
									String firstName = (String) eachMap.get("studentFirstName");
									String lastName = (String) eachMap.get("studentLastName");
									int age = (Integer) eachMap.get("studentAge");
									String classes = (String) eachMap.get("studentClass");
									
									%>
									<tr>
										<td><%=studentId%></td>
										<td><%=firstName%></td>
										<td><%=lastName%></td>
										<td><%=age%></td>
										<td><%=classes%></td>
									</tr>
									<%
								}
						%>
					</tbody>
					<a href="createStudent"><button class="btn btn-primary">Create Student</button></a>
				</table>
				<%
				
			}
		%>
		
		<%
			String classes = request.getParameter("classes");
			if (Objects.nonNull(classes)) {

				%>
				<p>List of Classes</p>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Class Id</th>
							<th>Class Name</th>
							<th>Class Teacher Name</th>
							<th>Class Student Count</th>
							
						</tr>
					</thead>
					<tbody>
						<%
							List<HashMap<Object, Object>> classList = new ObjectMapper().readValue(classes, List.class);
		
								for (HashMap<Object, Object> eachMap : classList) {
									String classId = (String) eachMap.get("classId");
									String className = (String) eachMap.get("className");
									String classTeacherName = (String) eachMap.get("classTeacherName");
									int classStudentCount = (Integer) eachMap.get("classStudentCount");
									
									
									%>
									<tr>
										<td><%=classId%></td>
										<td><%=className%></td>
										<td><%=classTeacherName%></td>
										<td><%=classStudentCount%></td>
										
									</tr>
									<%
								}
						%>
					</tbody>
					<a href="createClass"><button class="btn btn-primary">Create Class</button></a>
				</table>
				<%
				
			}
		%>
		
	<%
			String teachers = request.getParameter("teachers");
			if (Objects.nonNull(teachers)) {

				%>
				<p>List of Teachers</p>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Teacher Id</th>
							<th>Teacher Name</th>
							<th>Class Teacher</th>
							<th>Subject</th> 
                            <th>Age</th>
                            <th>Teacher Classes</th> 
							
						</tr>
					</thead>
					<tbody>
						<%
							List<HashMap<Object, Object>> teachersList = new ObjectMapper().readValue(teachers, List.class);
		
								for (HashMap<Object, Object> eachMap : teachersList) {
									int teachersId = (Integer) eachMap.get("teachersId");
									String teachersName = (String) eachMap.get("teachersName");
									String classTeacher = (String) eachMap.get("classTeacher");
									String subject = (String) eachMap.get("subject");
									int age = (Integer) eachMap.get("teachersAge");  
									String teachersClasses = (String) eachMap.get("teachersClasses");
									
									
									%>
									<tr>
										<td><%=teachersId%></td>
										<td><%=teachersName%></td>
										<td><%=classTeacher%></td>
										<td><%=subject%></td>
										<td><%=age%></td>
										<td><%=teachersClasses%></td>
										
									</tr>
									<%
								}
						%>
					</tbody>
					<a href="createTeacher"><button class="btn btn-primary">Create / Assign Teacher</button></a>
				</table>
				<%
				
			}
		%>
		
		<%
			String subjects = request.getParameter("subjects");
			if (Objects.nonNull(subjects)) {

				%>
				<p>List of Subjects</p>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Subject Id</th>
							<th>Subject</th>
							<th>Subject Teacher</th>
							<th>Subject Classes</th> 
                             
							
						</tr>
					</thead>
					<tbody>
						<%
							List<HashMap<Object, Object>> subjectList = new ObjectMapper().readValue(subjects, List.class);
		
								for (HashMap<Object, Object> eachMap : subjectList) {
									int subjectId = (Integer) eachMap.get("subjectId");
									String subject = (String) eachMap.get("subject");
									String subjectTeacher = (String) eachMap.get("subjectTeacher");
									String subjectClasses = (String) eachMap.get("subjectClasses");
									
									
									
									%>
									<tr>
										<td><%=subjectId%></td>
										<td><%=subject%></td>
										<td><%=subjectTeacher%></td>
										<td><%=subjectClasses%></td>
										
										
									</tr>
									<%
								}
						%>
					</tbody>
					<!-- <form name="createSubjectForm" method="post" action="createSubjectServlet">
					<a href="classes"><button class="btn btn-primary">Create / Assign Subject to Class</button></a>
					</form>  -->
					<a href="createSubject"><button class="btn btn-primary">Create / Assign Subject to Class</button></a>
					
				</table>
				<%
				
			}
		%>
		
	</div>

</body>
</html>
