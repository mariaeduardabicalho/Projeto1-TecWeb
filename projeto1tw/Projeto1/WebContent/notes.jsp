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

<script>
(function mudaCor1() {
	document.a.style.background = "red";
})();
	document.get
</script>


<title>Mural</title>
</head>
<% String usuario = (String)request.getAttribute("usuario");
 	 System.out.println(usuario);
	%>
<body>
<h1>Mural de Notas</h1>


	<jsp:useBean id="dao" class="br.edu.insper.DAO"/>
 
 <c:if test = "${usuario== null}">
 		<% 
 	 System.out.println("ENTROUNO IF NOTES");
	%>
	  <form action="Loga" method="POST">
   
    <input type="submit" value="Login" />
     </form>
   <h6> Ainda não é cadastrado?</h6>
     <form action="Cria1" method="POST">
   
    <input type="submit" value="Cadastro" />
     </form>
  
	 </c:if>
	
	<ul>
	
	<c:forEach var="nota" items="${dao.lista}" varStatus="id">
<!-- 	<li bgcolor="#${nota.categoria == 'aviso' ? 'bbffcc' : 'ffffbb'}">
 -->		
 		<li bgcolor="#${id.count%2 == 0 ? 'bbffcc' : 'ffffbb' }">
	<a href = "#" style = "background:#${id.count%2 == 0 ? 'FF5359' : 'B9F1FF' }">
	 <form action="Edita" method="GET">
	 
	<p> ${nota.nome_doc} </p> <br/>
     

	 <c:if test = "${nota.conteudo == 'nota com imagem'}">
	 <img src="data:image/jpg;base64,${nota.base64Image}" width="80" height="53"/>
	 </c:if>
	 
	 
	 <c:if test = "${nota.categoria == 'aviso'}">
	 	 mudaCor1();
	 </c:if>
	 	 <c:if test = "${nota.categoria == 'comum'}">
	 	 mudaCor2();
	 </c:if>
	 
	 
     <input type = "hidden" name = "tipo_doc" value= ${nota.tipo_doc} ><br/>
     <input type = "text" name = "conteudo" value= ${nota.conteudo} ><br/>
     <input type="hidden" name="id" value = ${nota.id}>
     <input type="hidden" name="usuarioid" value = ${nota.usuarioid}>
    <h6> ${dao.pegarnome(Integer.parseInt(nota.usuarioid))} ${dao.pegarsobrenome(Integer.parseInt(nota.usuarioid))} </h6>
      
    
     
      <input type="submit" value="Editar" />
   </form> </a>

	
   <form action="Apaga" method="GET">
   
   	<input type="hidden" name="id" value=${nota.id}>
   
    <input type="submit" value="Apagar" />
   </form>

	</li>
	</c:forEach>
	</ul>
 	
 	
 	 
	<form action="FicarLogado" method="GET">
    
   	<input type="hidden" name="username" value=${usuario}>
   	
   <input type="hidden" name="page" value="adicionaNota.jsp">
    <input type="submit" value="Adicionar Nota" />
   </form>
   
   <h0>                                                       
    </h0>
   
   <form action="Logout" method="POST">
    
    <input type="submit" value="Logout" />
   </form>
	
	
	
</body>
</html>