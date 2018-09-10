package br.edu.insper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
	 connection = DriverManager.getConnection("jdbc:mysql://localhost/Projeto1", "root", "Du858773");
	}
	public List<Notas> getLista() throws SQLException {
		List<Notas> Notas = new ArrayList<Notas>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.
			 prepareStatement("SELECT * FROM Notas");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
		Notas Notas1 = new Notas();
		Notas1.setId(rs.getInt("id"));
		Notas1.setNome(rs.getString("nome"));
		Notas1.setConteudo(rs.getString("conteudo"));
		Notas1.setTipo_doc(rs.getString("tipo_doc"));
		Notas.add(Notas1);
		}
		
		rs.close();
		stmt.close();
		return Notas;
	}
	public void adiciona(Notas nota) throws SQLException {
		String sql = "INSERT INTO Notas" +
		"(nome,conteudo , tipo_doc) values(?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stmt.setString(1,nota.getNome());
		
		stmt.setString(2,nota.getConteudo());
		
		stmt.setString(3,nota.getTipo_doc());
		
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