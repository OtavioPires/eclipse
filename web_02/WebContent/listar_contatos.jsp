<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.ufc.ContatoDAO" %>    
<%@ page import="br.ufc.Contato" %>    
<%@ page import="java.util.List" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar contatos</title>
</head>
<body>
	<h1>Listar contatos</h1>
	
	<%
		ContatoDAO cDAO = new ContatoDAO();
		List<Contato> contatos = cDAO.listar();
		
		for(Contato c : contatos){
			
	%>
		<b><%=c.getNome()%></b></br>
	<%} %>
</body>
</html>