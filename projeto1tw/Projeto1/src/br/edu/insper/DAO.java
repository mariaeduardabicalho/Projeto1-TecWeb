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
	 connection = DriverManager.getConnection("jdbc:mysql://localhost/basededados", "root", "Du858773");
	}
	public void adiciona(Notas nota) throws SQLException {
		String sql = "INSERT INTO Pessoa" +
		"(nome,nascimento,altura) values(?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stmt.setString(1,nota.getNome());
		
		stmt.setString(3,nota.getConteudo());
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