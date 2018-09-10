package br.edu.insper;

public class Notas {
	private Integer id;
	private String nome_doc;
	private String categoria;
	private String tipo_doc;
	private String conteudo;

	public Integer getId() {return this.id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getNome_doc() {return this.nome_doc;}
	public void setNome_doc(String nome_doc) {this.nome_doc = nome_doc;}
	
	public String getCategoria() {return this.categoria;}
	public void setCategoria(String categoria) {this.categoria = categoria;}
	
	public String getTipo_doc() {return this.tipo_doc;}
	public void setTipo_doc(String tipo_doc) {this.tipo_doc = tipo_doc;}
	
	public String getConteudo() {return this.conteudo;}
	public void setConteudo(String conteudo) {this.conteudo = conteudo;}
	

}
