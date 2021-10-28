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
	<h1> Create Class by filling below details  </h1>
		<form action="createClass" method="post">
			
			<div class="form-group">
				<label for="className">Enter Class Name :</label> 
				<input type="text" class="form-control" id="className" name="className" required >
			</div>
			<div class="form-group">
				<label for="classTeacherName">Enter Class Teacher Name :</label> 
				<input type="text" class="form-control" id="classTeacherName" name="classTeacherName"  required >
			</div>
			<div class="form-group">
				<label for="studentCount">Enter Students Count :  </label> 
				<input type="text" class="form-control" id="studentCount" name="studentCount" required>
			</div>
			
			<button type="submit" class="btn btn-primary">Create Class </button>
		</form>
	</div>
</body>
</html>