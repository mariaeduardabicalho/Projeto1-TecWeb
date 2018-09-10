<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--  <jsp:useBean id="Cria" class="br.edu.insper.Cria"/>
 --%>   
   <form action = "Posta" method = "POST">
      Titulo: <input type = "text" name = "nome"><br/>
      Conteudo: <input type = "text" name = "altura" /><br/>
      Tipo: <input type = "text" name = "tipo" />
      
      <input type = "submit" value = "Submit" />
   </form>
   
</body>
</html>