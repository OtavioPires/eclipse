<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Site do Tavinho</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	
	<h1>Listar Alunos</h1>
	
	<jsp:useBean id="aDAO" class="br.ufc.AlunoDAO" />
	
	<table border =1>
		<thead>
		<tr>
			<th>ID</th>
			<th>Matricula</th>
			<th>Nome</th>
			<th>Nascimento</th>
			<th>Email</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="aluno" items="${aDAO.listar()}">
		<tr>
			<td>${aluno.id} </td>
			<td>${aluno.matricula} </td>
			<td>${aluno.nome} </td>
			
			<c:choose>
				<c:when test="${not empty aluno.email}">
					<td>${aluno.email}</td>
				</c:when>
				<c:otherwise>
					<td>E-mail nao cadastrado</td>
				</c:otherwise>
			</c:choose>
			<td>
			<fmt:formatDate value="${aluno.nascimento}" pattern="dd/MM/yyyy"/>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<a href="index.jsp">Voltar</a>
		
	<c:import url="rodape.jsp" />
	
</body>
</html>