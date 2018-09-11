package br.edu.insper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Edita
 */
@WebServlet("/Edita")
public class Edita extends HttpServlet {
@Override
protected void doGet(HttpServletRequest request,
 HttpServletResponse response)
throws ServletException, IOException {
	response.sendRedirect("editanota.jsp");
}
@Override
protected void doPost(HttpServletRequest request,
 HttpServletResponse response)
throws ServletException, IOException {
DAO dao = null;
try {
	dao = new DAO();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
Notas nota = new Notas();
nota.setNome_doc(request.getParameter("nome_doc"));
nota.setConteudo(request.getParameter("conteudo"));
nota.setTipo_doc(request.getParameter("tipo_doc"));
nota.setCategoria(request.getParameter("categoria"));
nota.setId(Integer.valueOf(request.getParameter("id")));


try {
	dao.edita(nota);
	System.out.println("entrou");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
response.sendRedirect("notes.jsp");
dao.close();
}

}

