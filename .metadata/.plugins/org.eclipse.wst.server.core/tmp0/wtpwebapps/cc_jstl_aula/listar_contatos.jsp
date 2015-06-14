<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Introdução JSTL</title>
</head>
<body>

	<c:import url="cabecalho.jsp" />

	<h1>Listar Contatos</h1>
	cabecalho.jsp" />

	<h1>otavio baitola </h1>

	<jsp:useBean id="cDAO" class="br.ufc.ContatoDAO" />

	<table border=1>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nome</th> 
				<th>Endereço</th>
				<th>Celular</th>
				<th>Nascimento</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="contato" items="${cDAO.lista}">
				<tr>
					<td>${contato.id}</td>
					<td>${contato.nome}</td>
					<td>${contato.endereco}</td>

					<c:choose>
						<c:when test="${not empty contato.celular}">
							<td>${contato.celular}</td>
						</c:when>
						<c:otherwise>
							<td>NÃO CADASTRADO!</td>
						</c:otherwise>
					</c:choose>


					<%-- 
			<c:if test="${not empty contato.celular}">
				<td> ${contato.celular} </td>
			</c:if>
			<c:if test="${empty contato.celular}">
				<td> NÃO CADASTRADO </td>
			</c:if>
			--%>

					<td><fmt:formatDate value="${contato.nascimento}"
							pattern="dd/MM/yyyy" /></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="index.jsp">Voltar</a>

	<c:import url="rodape.jsp" />

</body>
</html>





