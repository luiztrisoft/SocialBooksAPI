package com.trisoft.socialbooks.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trisoft.socialbooks.domain.Autor;
import com.trisoft.socialbooks.repository.AutoresRepository;
import com.trisoft.socialbooks.services.exceptions.AutorExistenteException;
import com.trisoft.socialbooks.services.exceptions.AutorNaoEncontradoException;

@Service
public class AutoresService {
	
	@Autowired
	private AutoresRepository autoresRepository;
	
	public Autor salvar(Autor autor) {
		if(autor.getId() != null) {
			Autor a = autoresRepository.findById(autor.getId()).orElse(null);
			
			if(a != null) {
				throw new AutorExistenteException("O autor já existe.");
			}
		}
		return autoresRepository.save(autor);
	}
	
	public List<Autor> listar(){
		return autoresRepository.findAll();
	}
	
	public Autor buscar(Long id) {
		Autor autor = autoresRepository.findById(id).orElse(null);
		if(autor == null) {
			throw new AutorNaoEncontradoException("O autor não pôde ser encontrado.");
		}
		return autor;
	}
}
