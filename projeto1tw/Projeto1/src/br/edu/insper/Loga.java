package br.edu.insper;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loga
 */
@WebServlet("/Loga")
public class Loga extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean check = false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loga() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		DAO dao = null;
		try {
			dao = new DAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		Usuario usuario = new Usuario();
		
		try {
			System.out.println("no try");
			System.out.println(dao.getListau());
			
			for (Usuario usuariol:dao.getListau()) {

				 if (request.getParameter("username").equals( usuariol.getUsuario()) && request.getParameter("password").equals( usuariol.getSenha())) {
					 System.out.println("ENTROU NO IF");
					 usuario.setUsuario(request.getParameter("username"));
					 //usuario.setSenha(request.getParameter("password"));
					 request.setAttribute("usuario", usuario.getUsuario());
					 request.getRequestDispatcher("notes.jsp").forward(request, response);
					 
					 System.out.println("entrou");
					 
					
					
					 check = true;
				 }
				 	 
			 }
		if (check == false){
			System.out.println("Enao entrou no if else");
			 response.sendRedirect("login.jsp?invalid=true");
				 //response.sendRedirect("login.jsp");
			
		}	
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dao.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		;
		//doGet(request, response);
	}

}
