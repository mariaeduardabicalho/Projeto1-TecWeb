package br.edu.insper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DAO {
	
	private Connection connection = null;
	public DAO() throws SQLException {
	 try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 connection = DriverManager.getConnection("jdbc:mysql://localhost/Projeto1", "root", "");
	}
	public List<Notas> getLista() throws SQLException {
		List<Notas> Notas = new ArrayList<Notas>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.
			 prepareStatement("SELECT * FROM Notasteste");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
		Notas Notas1 = new Notas();
		Notas1.setId(rs.getInt("id"));
		Notas1.setNome_doc(rs.getString("nome_doc"));
		Notas1.setConteudo(rs.getString("conteudo"));
		Notas1.setTipo_doc(rs.getString("tipo_doc"));
		Notas1.setCategoria(rs.getString("categoria"));
		Notas.add(Notas1);
		
		}
		
		rs.close();
		stmt.close();
		return Notas;
	}
	public void adiciona(Notas nota) throws SQLException {
		String sql = "INSERT INTO Notasteste" +
		"(nome_doc,conteudo , tipo_doc, categoria) values(?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stmt.setString(1,nota.getNome_doc());
		
		stmt.setString(2,nota.getConteudo());
		
		stmt.setString(3,nota.getTipo_doc());
		
		stmt.setString(4,nota.getCategoria());
		
		System.out.println("atualizou");
		
		
		stmt.execute();
		stmt.close();
		}
	public void apaga(Integer id) throws SQLException {
		String sql = "DELETE FROM Notasteste WHERE id = ?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("apagou");
		stmt.setLong(1, id);
		
		
		stmt.execute();
		stmt.close();
		}
	
	public void edita(Notas nota) throws SQLException {
		String sql = "UPDATE Notasteste SET " +
		 "nome_doc=?, conteudo=?, tipo_doc=?, categoria=? WHERE id=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stmt.setString(1,nota.getNome_doc());
		
		stmt.setString(2,nota.getConteudo());
		
		stmt.setString(3,nota.getTipo_doc());
		
		stmt.setString(4,nota.getCategoria());

		stmt.setInt(5, nota.getId());
		stmt.execute();
		stmt.close();
		}
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}}