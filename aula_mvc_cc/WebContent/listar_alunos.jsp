<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar alunos</title>
</head>
<body>
<c:import url="cabecalho.jsp"/>



<h1>Listar Alunos: <b>${tamanho}</b> </h1>
<table border="1">
	<tr>
		<td><b>ID</b></td>
		<td><b>Nome</b></td>
		<td><b>Matricula</b></td>
		<td><b>Email</b></td>
		<td><b>Nascimento</b></td>
		<td><b>Excluir</b></td>
		
	</tr>
	<c:forEach var="alunos" items="${alunos}">
	<tr>
		<td>${alunos.id}</td>
		<td>${alunos.nome}</td>
		<%-- 
		<c:if test="${not empty alunos.matricula}">
			<td>${alunos.matricula}</td>
		</c:if>
		<c:if test="${empty alunos.matricula}">
			<td><b>Não Cadastrado!</b></td>
		</c:if>
		--%>
		<c:choose>
			<c:when test="${not empty alunos.matricula}">
				<td>${alunos.matricula}</td>
			</c:when>
			<c:otherwise>
				<td><b>Não Cadastrado!</b></td>
			</c:otherwise>
		</c:choose>
		
		
		
		<td>${alunos.email}</td>
		<td>
			<f:formatDate value="${alunos.nascimento}"
			 pattern="dd/MM/yyyy"/>
		</td>
		
		
		<td>
			<a href="principal?classe=ExcluirAlunoServlet&id=${alunos.id}">Excluir</a>
		</td>
		
	</tr>
	</c:forEach>
</table>
<c:import url="rodape.jsp"/>

</body>
</html>











