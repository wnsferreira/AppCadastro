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
	List<Usuario> usuarios = (List<Usuario>)request.getAttribute("lista");
	%>
	
	<div class="container">
		
		<form action="usuario" method="get">
			<button type="submit" class="btn btn-link" name="tela" value="lista">Incluir</button>
		</form>
		<hr>
		
		<h3>Quantidade de usuarios existentes: <%=usuarios.size()%>!</h3>
		
		<hr>
	        
	  <table class="table table-striped">
	    <thead>
	      <tr>
	        <th>Nome</th>
	        <th>Email</th>
	      </tr>
	    </thead>
	    <tbody>
		    <%for(Usuario user : usuarios) {%>
		     <tr>
		        <td><%=user.getNome()%></td>
		        <td><%=user.getEmail()%></td>
		      </tr>
			<%} %>
		     
	    </tbody>
	  </table>
	</div>
	</div>

	
	
		
	<form action="usuario" method="get">
		<button type="submit" class="btn btn-default">Voltar</button>
	</form>
</body>
</html>