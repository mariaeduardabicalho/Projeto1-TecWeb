<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<!DOCTYPE html>

<html>


<head>
<link  href="http://fonts.googleapis.com/css?
family=Reenie+Beanie:regular" 
rel="stylesheet"
type="text/css">
<link rel="stylesheet" type="text/css" href="notas.css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<% String usuario = (String)request.getAttribute("usuario");
 	 System.out.println(usuario);
	%>
<body>
<h0>  PROJETO 1 TEC WEB </h0>


	<jsp:useBean id="dao" class="br.edu.insper.DAO"/>
 
 <c:if test = "${usuario== null}">
 		<% 
 	 System.out.println("ENTROUNO IF NOTES");
	%>
	  <form action="Loga" method="POST">
   
    <input type="submit" value="Login" />
     </form>
   <h6> Ainda n�o � cadastrado?</h6>
     <form action="Cria1" method="POST">
   
    <input type="submit" value="Cadastro" />
     </form>
  
	 </c:if>
	
	<ul>
	
	<c:forEach var="nota" items="${dao.lista}" varStatus="id">
	<li>
	<a href = "#">
	 <form action="Edita" method="GET">

	
	 <c:if test = "${nota.conteudo == 'nota com imagem'}">
	 

	 <img src="data:image/jpg;base64,${nota.base64Image}" width="80" height="53"/>
	 </c:if>
	 
	 
     <h1>  < ${nota.nome_doc} > <br/></h1>
     
     <input type = "text" name = "categoria" value= ${nota.categoria} ><br/>
     <input type = "hidden" name = "tipo_doc" value= ${nota.tipo_doc} ><br/>
     <input type = "text" name = "conteudo" value= ${nota.conteudo} ><br/>
     <input type="hidden" name="id" value = ${nota.id}>
     <input type="hidden" name="usuarioid" value = ${nota.usuarioid}>
 
    <h6> ${dao.pegarnome(Integer.parseInt(nota.usuarioid))} ${dao.pegarsobrenome(Integer.parseInt(nota.usuarioid))} </h6>
      <h6> ${nota.data_postagem} </h6> <br/>
    
     
      <input type="submit" value="Editar" />
   </form> </a>

	
   <form action="Apaga" method="GET">
   
   	<input type="hidden" name="id" value=${nota.id}>
   
    <input type="submit" value="Apagar" />
   </form>

	</li>
	</c:forEach>
	</ul>
 	
 	
 	  <c:if test = "${usuario!= null}">

  <form action="FicarLogado" method="GET">
    
   	<input type="hidden" name="username" value=${usuario}>
   	
   <input type="hidden" name="page" value="adicionaNota.jsp">
    <input type="submit" value="Adicionar Nota" />
   </form>
   
	 </c:if>
	
   <h0>                                                       
    </h0>
   
   <form action="Logout" method="POST">
    
    <input type="submit" value="Logout" />
   </form>
	
	
	
</body>
</html>