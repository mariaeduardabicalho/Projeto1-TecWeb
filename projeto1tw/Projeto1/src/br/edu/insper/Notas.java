package br.edu.insper;

import java.io.InputStream;

import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


import com.mysql.cj.jdbc.Blob;

public class Notas {
	private Integer id;
	private Integer usuarioid;
	private String nome_doc;
	private String categoria;
	private String tipo_doc;
	private String conteudo;
	private Date data_postagem;
	private InputStream imagem;
	private String base64Image;
	
	
	

	public Integer getId() {return this.id;}
	public void setId(Integer id) {this.id = id;}
	
	public Integer getUsuarioid() {return this.usuarioid;}
	public void setUsuarioid(Integer usuarioid) {this.usuarioid = usuarioid;}
	
	public String getNome_doc() {return this.nome_doc;}
	public void setNome_doc(String nome_doc) {this.nome_doc = nome_doc;}
	
	public String getCategoria() {return this.categoria;}
	public void setCategoria(String categoria) {this.categoria = categoria;}
	
	public String getTipo_doc() {return this.tipo_doc;}
	public void setTipo_doc(String tipo_doc) {this.tipo_doc = tipo_doc;}
	
	public Date getData_postagem() {return this.data_postagem;}
	public void setData_postagem(Date data_postagem) {this.data_postagem= data_postagem;}
	
	
	public String getConteudo() {return this.conteudo;}
	public void setConteudo(String conteudo) {this.conteudo = conteudo;}
	
	public InputStream getImagem() {
		return imagem;
	}
	public void setImagem(InputStream imagem) {
		this.imagem = imagem;
	}
	public String getBase64Image() {
		return base64Image;
	}
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	
	

}
