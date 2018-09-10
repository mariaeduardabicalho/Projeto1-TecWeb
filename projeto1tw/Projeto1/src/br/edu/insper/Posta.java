package br.edu.insper;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import DAO;
//import Notas;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Servlet implementation class Posta
 */
@WebServlet("/Posta")
public class Posta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Posta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request,
    		 HttpServletResponse response)
    		 throws ServletException, IOException {
    		 PrintWriter out = response.getWriter();
    		
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
    		 
    		 




    		 try {
    			dao.adiciona(nota);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		 response.sendRedirect("notes.jsp");
    		 dao.close();
    		 }
    		 
    		}
