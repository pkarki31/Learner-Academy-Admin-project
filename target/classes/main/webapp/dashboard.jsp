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
<style>
.styled-table {
    
    margin: 30px 0;
    font-size: 2em;
    font-family: sans-serif;
    min-width: 500px;
    box-shadow: 0 0 30px rgba(0, 0, 0, 0.15);
}

.styled-table thead tr {
    background-color: #009879;
    color: #ffffff;
    text-align: left;
}

.styled-table th,
.styled-table td {
    padding: 8px 35px;
}

.styled-table tbody tr {
    border-bottom: 4px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
    border-bottom: 2px solid #009879;
}

.styled-table tbody tr.active-row {
    font-weight: bold;
    color: #009879;
}

.button {
  display: inline-block;
  padding: 15px 25px;
  font-size: 20px;
  cursor: pointer;
  text-align: center;
  text-decoration: none;
  outline: none;
  color: #fff;
  background-color: #009879;
  border: none;
  border-radius: 15px;
  box-shadow: 0 9px #999;
}

.button:hover {background-color: #3e8e41}

.button:active {
  background-color: #3e8e41;
  box-shadow: 0 5px #666;
  transform: translateY(4px);



</style>
</head>
<body>
	<%
		String usernameSession = (String) session.getAttribute("username");
		if (session.getAttribute("username") == null) {
			response.sendRedirect("invalid.jsp?error=1");
		}
	%>
	<div class="container mt-3">
	<marquee>
		<h1>********   Welcome to Geeta International School   ******** </h1>
	</marquee>
		
		  <div style="float:right">
		  <a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
		  </div>
		  <a href="students"> <button class="button">View Students</button></a>
		  <a href="teachers"> <button class="button">View Teachers</button></a>
		  <a href="subjects"> <button class="button">View Subjects</button></a>
		  <a href="classes"> <button class="button">View Classes</button></a>
		  
		<%
			String students = request.getParameter("students");
			if (Objects.nonNull(students)) {

				%>
				<p>&nbsp</p>
				<table class="styled-table">
					<thead>
						<tr>
							<th>Student Id</th>
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
									<tr class="active-row">
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
					<a href="createStudent"> <button class="button">Create Student</button></a>
				</table>
				<%
				
			}
		%>
		
		<%
			String classes = request.getParameter("classes");
			if (Objects.nonNull(classes)) {

				%>
				<p>&nbsp</p>
				<table class="styled-table">
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
									<tr class="active-row">
										<td><%=classId%></td>
										<td><%=className%></td>
										<td><%=classTeacherName%></td>
										<td><%=classStudentCount%></td>
										
									</tr>
									<%
								}
						%>
					</tbody>
					<a href="createClass"> <button class="button">Create Class</button></a>
				</table>
				<%
				
			}
		%>
		
	<%
			String teachers = request.getParameter("teachers");
			if (Objects.nonNull(teachers)) {

				%>
				<p>&nbsp</p>
				<table class="styled-table">
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
									<tr class="active-row">
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
					<a href="createTeacher"> <button class="button">Create / Assign Teacher</button></a>
				</table>
				<%
				
			}
		%>
		
		<%
			String subjects = request.getParameter("subjects");
			if (Objects.nonNull(subjects)) {

				%>
				<p>&nbsp</p>
				<table class="styled-table">
					<thead>
						<tr >
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
									<tr class="active-row">
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
					<a href="createSubject"> <button class="button">Create / Assign Subject to Class</button></a>
					
				</table>
				<%
				
			}
		%>
		
	</div>

</body>
</html>
