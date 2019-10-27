package com.trisoft.socialbooks.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "livro")
public class Livro {

	@Id
	@JsonInclude(Include.NON_NULL)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "O nome não pode ser vazio.")
	private String nome;

	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "A data de publicação é obrigatória.")
	private LocalDate publicacao;

	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "A editora é obrigatória.")
	private String editora;

	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "O resumo deve ser preenchido.")
	@Size(max = 1500, message = "O resumo não pode conter mais de 1500 caracteres.")
	private String resumo;

	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "livro")
	private List<Comentario> comentarios;

	@ManyToOne
	@JoinColumn(name = "AUTOR_ID")
	@JsonInclude(Include.NON_NULL)
	private Autor autor;

	public Livro() {
	}

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

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}
}
