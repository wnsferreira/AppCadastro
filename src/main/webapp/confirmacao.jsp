<%@page import="br.edu.infnet.model.domain.Usuario"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmação!</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<%
	String nome = (String)request.getAttribute("nomeDoUsuario");
	%>

	<h2>O usuário <%=nome%> foi cadastrado com sucesso!</h2>
	
	<hr>
		
	<form action="usuario" method="get">
		<button type="submit" class="btn btn-default">Voltar</button>
	</form>
</body>
</html>