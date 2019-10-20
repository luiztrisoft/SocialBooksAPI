package com.trisoft.socialbooks.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "livro")
public class Livro {
	
	@Id
	@JsonInclude(Include.NON_NULL)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@JsonInclude(Include.NON_NULL)
	private LocalDate publicacao;
	
	@JsonInclude(Include.NON_NULL)
	private String editora;
	
	@JsonInclude(Include.NON_NULL)
	private String resumo;
	
	@JsonInclude(Include.NON_NULL)
	@OneToMany(mappedBy = "livro")
	private List<Comentario> comentarios;
	
	@JsonInclude(Include.NON_NULL)
	private String autor;
	
	public Livro() {}
	
	public Livro(String nome) {
		this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getPublicacao() {
		return publicacao;
	}
	public void setPublicacao(LocalDate publicacao) {
		this.publicacao = publicacao;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getResumo() {
		return resumo;
	}
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	public List<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

	
}
