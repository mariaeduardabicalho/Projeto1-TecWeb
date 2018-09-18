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
	 connection = DriverManager.getConnection("jdbc:mysql://localhost/Projeto1", "root", "Du858773");
	}
	public List<Usuario> getListau() throws SQLException {
		List<Usuario> usuario = new ArrayList<Usuario>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement("SELECT * FROM usuario");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
		Usuario usuario1 = new Usuario();
		usuario1.setId(rs.getInt("id"));
		usuario1.setPrimeiro_nome(rs.getString("primeiro_nome"));
		usuario1.setSobrenome(rs.getString("sobrenome"));
		usuario1.setEmail(rs.getString("email"));
		usuario1.setTipo(rs.getString("tipo"));
		usuario1.setUsuario(rs.getString("usuario"));
		usuario1.setSenha(rs.getString("senha"));
		usuario.add(usuario1);
		
		}
		
		rs.close();
		stmt.close();
		return usuario;
	}
	public List<Notas> getLista() throws SQLException {
		List<Notas> Notas = new ArrayList<Notas>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.
			 prepareStatement("SELECT * FROM Notes");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
		Notas Notas1 = new Notas();
		Notas1.setId(rs.getInt("id"));
		Notas1.setId(rs.getInt("pessoa_id"));
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
	
	public void adicionau(Usuario usuario) throws SQLException {
		String sql = "INSERT INTO usuario" +
		"(primeiro_nome,sobrenome , email, tipo, usuario, senha) values(?,?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stmt.setString(1,usuario.getPrimeiro_nome());
		
		stmt.setString(2,usuario.getSobrenome());
		
		stmt.setString(3,usuario.getEmail());
		
		stmt.setString(4,usuario.getTipo());
		
		stmt.setString(5,usuario.getUsuario());
		
		stmt.setString(6,usuario.getSenha());
		
		//System.out.println("atualizou");
		
		
		stmt.execute();
		stmt.close();
		}
	

	public void adiciona(Notas nota) throws SQLException {
		String sql = "INSERT INTO Notes" +
		"( nome_doc,conteudo , tipo_doc, categoria, pessoa_id) values(?,?,?,?,?)";
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
		
		stmt.setInt(5,nota.getUsuarioid());
		
		//System.out.println("atualizou");
		
		
		stmt.execute();
		stmt.close();
		}
	
	public void apaga(Integer id) throws SQLException {
		String sql = "DELETE FROM Notes WHERE id = ?";
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
		String sql = "UPDATE Notes SET " +
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
}
//	public Integer pegarid(String usuario) throws SQLException {
//		Usuario usuario1 = new Usuario();
//		PreparedStatement stmt = null;
//		try {
//			stmt = connection.
//			 prepareStatement("SELECT usuario FROM usuario where usuario=?");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ResultSet rs = stmt.executeQuery();
//		
//	
//		stmt.setString(1, usuario);
//		
//		usuario1.setId(rs.getInt("id"));
//		Integer usuarioid= usuario1.getId();
//		
//		
//		rs.close();
//		stmt.close();
//		return usuarioid;
//	}
	
	public Integer pegarId(String usuario) throws SQLException {
		String sql = "SELECT id FROM usuario where usuario=?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		stmt.setString(1, usuario);
		
		ResultSet rs = stmt.executeQuery();
		Integer id = null;
		while (rs.next()) {
		System.out.println(rs);
		id=Integer.parseInt(rs.getObject(1).toString());;
		System.out.println(id);
		}
		
		rs.close();
		stmt.close();
		return id;
		}
	
	
	
	}