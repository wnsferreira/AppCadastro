<%@page import="br.edu.infnet.model.domain.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmação!</title>
</head>
<body>

	<%
	String nome = (String)request.getAttribute("nomeDoUsuario");
	List<Usuario> usuarios = (List<Usuario>)request.getAttribute("lista");
	int qtde = usuarios.size();
	%>

	<h2>O usuário <%=nome%> foi cadastrado com sucesso!</h2>
	<h3>Quantidade de usuarios existentes: <%=qtde%>!</h3>
	
	<hr>
	
	<%for(Usuario user : usuarios) {%>
		<h3>Usuario: <%=user.getNome()%> </h3>
	<%} %>
		
	<form action="usuario" method="get">
		<button type="submit" class="btn btn-default">Voltar</button>
	</form>
</body>
</html>