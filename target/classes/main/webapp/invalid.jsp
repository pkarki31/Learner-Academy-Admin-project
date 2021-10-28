<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page</title>
</head>
<body>
	<%
		Integer errorCode = Integer.parseInt(request.getParameter("error"));
		if (errorCode == 1) {
	%>
	<script>
		alert("Error occurred, User doesn't exist");
	</script>
	<%
		} else if (errorCode == 2) {
			out.println("<h1> Error occurred, Invalid credentials</h1>");
		}
	%>

	<a href="JSPSessions.jsp"><span class="glyphicon glyphicon-log-in"></span>
		Login</a>
</body>
</html>