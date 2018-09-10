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
<body>
	<jsp:useBean id="dao" class="br.edu.insper.DAO"/>
	<ul>
	
	<c:forEach var="nota" items="${dao.Notas}" varStatus="id">
	<li>
	<a href = "#">
	<h2>${nota.getNome()}</h2>
	<p>${nota.getConteudo()}</p></a>
	</li>
	
	</c:forEach>
	</ul>


</body>
</html>