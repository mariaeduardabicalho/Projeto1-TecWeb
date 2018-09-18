<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>

<html>


<head>
<link rel="stylesheet" type="text/css" href="notas.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
PROJETO 1 TEC WEB
<body>
	<jsp:useBean id="dao" class="br.edu.insper.DAO"/>
	
	<ul>
	
	<c:forEach var="nota" items="${dao.lista}" varStatus="id">
	<li>
	<a href = "#">
	 <form action="Edita" method="GET">
	 
     <input type = "text" name = "nome_doc" value= ${nota.nome_doc} ><br/>
     <input type = "text" name = "categoria" value= ${nota.categoria} ><br/>
     <input type = "hidden" name = "tipo_doc" value= ${nota.tipo_doc} ><br/>
     <input type = "text" name = "conteudo" value= ${nota.conteudo} ><br/>
     <input type="hidden" name="id" value=${nota.id}>
     
      <input type="submit" value="Editar" />
   </form> </a>

	
   <form action="Apaga" method="GET">
   
   	<input type="hidden" name="id" value=${nota.id}>
   
    <input type="submit" value="Apagar" />
   </form>

	</li>
	</c:forEach>
	<!--   <form action="loga" method="POST">
 
   
    <input type="submit" value="Login" /> 
   </form>-->
	</ul>
	<% String usuario = (String)request.getAttribute("usuario");
	System.out.println(usuario);%>
	<form action="FicarLogado" method="GET">
    
   	<input type="hidden" name="username" value=${usuario}>
   	
   <input type="hidden" name="page" value="adicionaNota.jsp">
    <input type="submit" value="Adicionar Nota" />
   </form>
	
	
	
</body>
</html>