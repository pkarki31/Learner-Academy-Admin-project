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
	<h1> Create Subject by filling below details  </h1>
		<form action="createSubject" method="post">
			
			<div class="form-group">
				<label for="subjectName">Enter Subject Name :</label> 
				<input type="text" class="form-control" id="subjectName" name="subjectName" required >
			</div>
			<div class="form-group">
				<label for="subjectName">Enter Teacher for this Subject :</label> 
				<input type="text" class="form-control" id="subjectTeacher" name="subjectTeacher" required>
			</div>
			<div class="form-group">
				<label for="subjectClass">Enter Class / Classes for this Subject :</label> 
				<input type="text" class="form-control" id="subjectClass" name="subjectClass" required>
			</div>
			<button type="submit" class="btn btn-primary">Create Subject </button>
		</form>
	</div>
</body>
</html>