<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="login.css">'
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dao" class="br.edu.insper.DAO"/>
 
 <form action = "Loga" method = "POST">
<fieldset>
    <legend>Sign in</legend>
    
    
    <div>
        <label for="userName">  Username:</label>
        <input type="text" id="username" name="username"
               required />
         <c:forEach var="usuario" items="${dao.listau}" varStatus="id">
	<li>
	
	<c:if test=${usuario.primeiro_nome == Username  }  ></c:if>
   </li>
	</c:forEach>
	</ul>
    </div>
    
    <div>
        <label for="password">Password:</label>
        <input type="password" id="password" name="password"
               minlength="8" required
               placeholder="8 characters minimum" />
    </div>
    
 
  
	<ul>
	
	


    

    <input type="submit" value="Sign in">

</fieldset>
 </form>
</body>

</html>