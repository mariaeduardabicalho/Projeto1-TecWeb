<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<%!
public class Notas {
	private Integer id;
	private String nome;
	private String categoria;
	private String tipo_doc;
	

	public Integer getId() {return this.id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getNome() {return this.nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	

}
%>



<html>
<head>
<link rel="stylesheet" type="text/css" href="notas.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<ul>
  <li>
    <a href="#">
      <h2>nota 1</h2>
      <p>Text Content 1</p>
    </a>
  </li>
  <li>
    <a href="#">
      <h2>nota 2</h2>
      <p>Text Content 2</p>
    </a>
  </li>
</ul>

</body>
</html>