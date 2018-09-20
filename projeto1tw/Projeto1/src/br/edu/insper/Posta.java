package br.edu.insper;


import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;


import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.junit.jupiter.api.Test;

//import DAO;
//import Notas;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Servlet implementation class Posta
 */
@WebServlet("/Posta")
@MultipartConfig
public class Posta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Test
	public void toBytes() 
	  throws IOException {
	    InputStream initialStream = new ByteArrayInputStream(new byte[] { 0, 1, 2 });
	 
	    byte[] targetArray = new byte[initialStream.available()];
	    initialStream.read(targetArray);
	}
       
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
		    String conteudo = request.getParameter("conteudo"); 
		    InputStream fileContent = null;
		    
		    if(conteudo == null) {
   		 	
		    Part filePart = request.getPart("arquivo"); 
		   fileContent = (InputStream) filePart.getInputStream();
		    }
		    InputStream stream = new ByteArrayInputStream("sem imagem".getBytes(StandardCharsets.UTF_8));
		    
    		 DAO dao = null;
    		try {
    			dao = new DAO();
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		 Notas nota = new Notas();
    		 
    		 if(conteudo != null) {
    		 nota.setNome_doc(request.getParameter("nome_doc"));
    		 nota.setConteudo(request.getParameter("conteudo"));
    		 nota.setTipo_doc(request.getParameter("tipo_doc"));
    		 nota.setCategoria(request.getParameter("categoria"));
    		 nota.setImagem(stream);
    		 nota.setUsuarioid(Integer.parseInt(request.getParameter("usuarioid")));
    		 
    		 //System.out.println(nota.getUsuarioid());
    		 //System.out.println("POSTA!!!");
    		 
    		 }
    		 else {
        		 nota.setNome_doc(request.getParameter("nome_doc"));
        		nota.setImagem(fileContent);
        		 nota.setTipo_doc(request.getParameter("tipo_doc"));
        		 nota.setCategoria(request.getParameter("categoria"));
        		 nota.setConteudo("nota com imagem");
        		 nota.setUsuarioid(Integer.parseInt(request.getParameter("usuarioid")));
    		 }

    		 try {
    			dao.adiciona(nota);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		 String usuario = null;
			try {
				System.out.println("ENTROU NO TRY POSTA");
				usuario = dao.pegarusuario(nota.getUsuarioid());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 //response.sendRedirect("notes.jsp");
			System.out.println(usuario);
    		 request.setAttribute("usuario", usuario);
			 request.getRequestDispatcher("notes.jsp").forward(request, response);
    		 dao.close();
    		 }
    		 
    		}
