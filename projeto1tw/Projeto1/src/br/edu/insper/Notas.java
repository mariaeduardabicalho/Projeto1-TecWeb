package br.edu.insper;

public class Notas {
	private Integer id;
	private String nome;
	private String categoria;
	private String tipo_doc;
	private String conteudo;

	public Integer getId() {return this.id;}
	public void setId(Integer id) {this.id = id;}
	
	public String getNome() {return this.nome;}
	public void setNome(String nome) {this.nome = nome;}
	
	public String getCategoria() {return this.categoria;}
	public void setCategoria(String categoria) {this.nome = categoria;}
	
	public String getTipo_doc() {return this.tipo_doc;}
	public void setTipo_doc(String tipo_doc) {this.tipo_doc = tipo_doc;}
	
	public String getConteudo() {return this.conteudo;}
	public void setConteudo(String conteudo) {this.conteudo = conteudo;}
	

}
