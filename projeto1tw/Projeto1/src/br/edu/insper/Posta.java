package br.edu.insper;


import java.awt.Image;
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

//import DAO;
//import Notas;

import java.io.IOException;
import java.io.PrintWriter;
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
		    String conteudo = request.getParameter("conteudo"); // Retrieves <input type="text" name="description">
   		 	
		    Part filePart = request.getPart("arquivo"); // Retrieves <input type="file" name="file">
		    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		    System.out.println(fileName.getClass());
		    System.out.println(fileName);
		    InputStream fileContent = (InputStream) filePart.getInputStream();
		    Image image = ImageIO.read(fileContent);
		    String contents = fileContent.toString();
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
    		 }
    		 else {
        		 nota.setNome_doc(request.getParameter("nome_doc"));
        		 nota.setConteudo(request.getParameter("arquivo"));
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
    		 response.sendRedirect("notes.jsp");
    		 dao.close();
    		 }
    		 
    		}
