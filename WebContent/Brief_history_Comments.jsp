<%@page import="db.DbManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="script.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Brief_history_comments</title>
<link rel="stylesheet" type="text/css" href="main_style.css">

</head>
<body>
	<h1 class=heading><%out.print("Hello!"); %></h1>
	<%= new java.util.Date() %>
	
	
	<%! int number1, number2; %>
	<%
	DbManager db = new DbManager();
	Connection conn = (Connection) db.getConnection();
	if(conn == null)
		out.print("failed");
	else
		out.print("succeeded");
	
	%>
	<div style="text-align:right"><a id=logout href="logout.jsp">logout</a></div>
	<h1 class="heading">Comments:</h1>
	<div class=main>
	<form name="comment" action="comment" method="post" onsubmit="return commentValidate()" >
	<br>
	${message}<br>
	${successMessage}<br>
	
	
	Comment:<input type="text" name="comment" id="comment"><br>
	<input type="submit" name="submit" value="comment"><br>
	
	</form>
	</div>
</body>
</html>