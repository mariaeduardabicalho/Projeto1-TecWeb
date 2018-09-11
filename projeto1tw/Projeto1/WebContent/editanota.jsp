<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action = "Edita" method = "POST">
  	 ID: <input type = "number" name = "id"><br/>
      Titulo: <input type = "text" name = "nome_doc"><br/>
      Conteudo: <input type = "text" name = "conteudo" /><br/>
      Tipo: <input type = "text" name = "tipo_doc" /><br/>
      Categoria:<input type = "text" name = "categoria" />
      
      <input type = "submit" value = "Submit" />
   </form>

</body>
</html>