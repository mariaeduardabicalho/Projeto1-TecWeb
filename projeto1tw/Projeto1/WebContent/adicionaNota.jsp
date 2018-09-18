<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<meta charset="UTF-8">
<title>Adicionar Nota</title>
</head>
<body>

<!--     <form action = "Posta" method = "POST">
      <div>Titulo: <input type = "text" name = "nome_doc"><br/></div>
      <div>Conteudo: <input type = "text" name = "conteudo" /><br/></div>
      <div>Tipo: <input type = "text" name = "tipo_doc" /><br/></div>
      <div>Categoria:<input type = "text" name = "categoria" /></div>
      enctype = "multipart/form-data"
      <input type = "submit" value = "Submit" />
   </form>
  -->
<div style = "text-align:center"><h1>Preencha sua Nota</h1></div>

<section class = "container">

	<div class = "col-lg-4"></div>  

   <form action = "Posta" method = "POST"  class = "col-lg-4" enctype="multipart/form-data">  
	   
		<div class="form-group escondido">
	   		<label  for="nome_doc">Título</label>
	    	<input type="text" class="form-control" name = "nome_doc"/>
	 	</div>
  
		<div>
			<p>Escolha o tipo da sua nota: </p><button 
			type = "button" onClick="loadDoc('notaTexto.jsp',myFunction)" name="tipo_doc" value = "Texto">Texto</button>
			<button type = "button" onClick="loadDoc('notaImagem.jsp',myFunction)" name="tipo_doc" value = "Imagem">Imagem</button>
		</div>

		<script>
			function loadDoc(url, cFunction) {
			  var xhttp = new XMLHttpRequest();
			  xhttp.onreadystatechange = function() {
			    if (this.readyState == 4 && this.status == 200) {
			      cFunction(this);
			    }
			  };
			  xhttp.open("GET", url, true);
			  xhttp.send();
			}
			
			
			function myFunction(xhttp) {
				  document.getElementById("conteudo").innerHTML =
					  xhttp.responseText;
				} 
		</script>

		<div id = "conteudo"></div>

  
		<div class="form-group">
		  <% Integer usuarioid = (Integer) request.getAttribute("usuarioid");
	System.out.println(usuarioid);%>
		    <label for="categoria">Categoria</label>
		    <input type="text" class="form-control" name = "categoria"/>
		    <input type="hidden"  name = "usuarioid" value= ${usuarioid} />
		</div>
  
		<input type = "submit" value = "Enviar" />
	</form>
	<div class = "col-lg-4"></div>
</section> 
</body>
</html>