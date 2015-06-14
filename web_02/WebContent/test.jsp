<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>My friend got a boyfriend and she hates that dick!</h1>
	
	SCRIPTLETS!</BR></BR>
	
	<% String msg = "Using out.print()";%>
	<% String msg2 = "Using =msg; A shortcut to out.print()";%>
	
	<h3>Showing results of msg</h3>
	<% for(int i=0;i<10;i++){ %>
	<%=msg2 %> </br>
	<% out.print(msg); %> </br>
	<%} %>
	
</body>
</html>