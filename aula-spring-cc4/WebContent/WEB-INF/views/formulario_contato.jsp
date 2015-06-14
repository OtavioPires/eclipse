<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="adicionarContato" method="POST">
		<table>
			<tr>
				<td>Nome</td>
				<td>
					<input type="text" name="nome" />
					
					<form:errors cssStyle="color:red" path="contato.nome"/>
				</td>
			</tr>
			
			<tr>
				<td>Celular</td><td><input type="text" name="celular" /></td>
			</tr>
			<tr>
				<td>Endereço</td><td><input type="text" name="endereco" /></td>
			</tr>
			<tr>	
				<td>Nascimento</td><td><input type="text"	name="nascimento" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Inserir" /></td>
			</tr>
		</table>
	</form>

</body>
</html>