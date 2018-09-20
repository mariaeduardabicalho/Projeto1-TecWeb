package br.edu.insper;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Apaga
 */
@WebServlet("/Apaga")
public class Apaga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Apaga() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao = null;
		try {
			dao = new DAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 
		 
		 try {
			dao.apaga(Integer.valueOf(request.getParameter("id")));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 //response.sendRedirect("notes.jsp");
		 Usuario usuario1 = new Usuario();
			
		usuario1.setUsuario(request.getParameter("username"));
		
		String usuario=  usuario1.getUsuario();
		
		System.out.println(usuario);
		 request.setAttribute("usuario", usuario);
			 request.getRequestDispatcher("notes.jsp").forward(request, response);
		 dao.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 
		 
		
	}

}
