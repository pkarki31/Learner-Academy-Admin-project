<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Geeta International School</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<%
		if (request.getParameter("error") != null) {
			out.println("<br> Your session has expired or it is invalid!");
		}
	%>
	<div class="container">
	<h1> Create Teachers by filling below details  </h1>
		<form action="createTeacher" method="post">
			
			<!-- <div class="form-group">
				<label for="teachersId">Enter Teacher Name :</label> 
				<input type="text" class="form-control" id="teachersId" name="teachersId" required >
			</div> -->
			<div class="form-group">
				<label for="teacherName">Enter Teacher Name :</label> 
				<input type="text" class="form-control" id="teacherName" name="teacherName" required >
			</div>
			<div class="form-group">
				<label for="classTeacher">Assign Class for which Teacher is class Teacher :</label> 
				<input type="text" class="form-control" id="classTeacher" name="classTeacher">
			</div>
			<div class="form-group">
				<label for="subject">Assign Subject to Teacher :</label> 
				<input type="text" class="form-control" id="subject" name="subject" required>
			</div>
			
			<div class="form-group">
				<label for="age">Enter Age of Teacher :</label> 
				<input type="text" class="form-control" id="age" name="age" required>
			</div>
			
			<div class="form-group">
				<label for="teacherClasses">Assign Classes to Teacher :</label> 
				<input type="text" class="form-control" id="teacherClasses" name="teacherClasses" >
			</div>
			
			<button type="submit" class="btn btn-primary">Create Teacher </button>
		</form>
	</div>
</body>
</html>