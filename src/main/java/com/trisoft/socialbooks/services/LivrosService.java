package com.trisoft.socialbooks.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.trisoft.socialbooks.domain.Comentario;
import com.trisoft.socialbooks.domain.Livro;
import com.trisoft.socialbooks.repository.ComentariosRepository;
import com.trisoft.socialbooks.repository.LivrosRepository;
import com.trisoft.socialbooks.services.exceptions.LivroNaoEncontradoException;

@Service
public class LivrosService {
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@Autowired
	private ComentariosRepository comentariosRepository;
	
	private final String LIVRO_NAO_ENCONTRADO = "O livro não foi encontrado.";
	
	public Livro salvar(Livro livro) {
		livro.setId(null);
		return livrosRepository.save(livro);		
	}
	
	public void atualizar(Livro livro) {
		verificarExistencia(livro);
		livrosRepository.save(livro);
	}
		
	public List<Livro> listar(){
		return livrosRepository.findAll();
	}
	
	public Livro buscar(Long id) {
		Livro livro = livrosRepository.findById(id).orElse(null);		
		if(livro == null) {
			throw new LivroNaoEncontradoException(LIVRO_NAO_ENCONTRADO);
		}			
		return livro;
	}
	
	public void deletar(Long id) {
		try {
			livrosRepository.deleteById(id);			
		}catch (EmptyResultDataAccessException e) {
			throw new LivroNaoEncontradoException(LIVRO_NAO_ENCONTRADO);
		}
	}
	
	public Comentario salvarComentario(Long livroId, Comentario comentario) {
		Livro livro = buscar(livroId);		
		comentario.setLivro(livro);
		comentario.setData(LocalDate.now());		
		return comentariosRepository.save(comentario);
	}
	
	public List<Comentario> listarComentario(Long livroId){
		Livro livro = buscar(livroId);
		return livro.getComentarios();
	}
	
	private void verificarExistencia(Livro livro) {
		buscar(livro.getId());
	}
}
