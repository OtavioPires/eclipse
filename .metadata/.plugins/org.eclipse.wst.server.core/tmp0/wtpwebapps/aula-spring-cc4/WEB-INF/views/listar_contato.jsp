<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Listar Contatos: <b>${qtd}</b> </h1>
<table border="1">
	<tr>
		<td><b>Nome</b></td>
		<td><b>Celular</b></td>
		<td><b>Endereço</b></td>
		<td><b>Nascimento</b></td>
		<td><b>Ação</b></td>
	</tr>
	<c:forEach var="contato" items="${contatos}">
	<tr>
		<td>${contato.nome}</td>
		<c:choose>
			<c:when test="${not empty contato.celular}">
				<td>${contato.celular}</td>
			</c:when>
			<c:otherwise>
				<td><b>Não Cadastrado!</b></td>
			</c:otherwise>
		</c:choose>
		
		<td>${contato.endereco}</td>
		<td>
			<f:formatDate value="${contato.nascimento}"
			 pattern="dd/MM/yyyy"/>
		</td>
		<td>
			<a href="excluirContato?id=${contato.id}">Excluir</a>
		</td>
	</tr>
	</c:forEach>
	
</table>



</body>
</html>