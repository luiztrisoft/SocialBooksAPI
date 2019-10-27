package com.trisoft.socialbooks.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.trisoft.socialbooks.domain.Autor;
import com.trisoft.socialbooks.services.AutoresService;

@RestController
@RequestMapping("/autores")
public class AutoresResource {
	
	@Autowired
	private AutoresService autoresService;
	
	@PostMapping
	public ResponseEntity<Void> salvar(@Valid @RequestBody Autor autor){
		autor = autoresService.salvar(autor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(autor.getId()).toUri();
		return ResponseEntity.created(uri).build();		
	}
	
	@GetMapping
	public ResponseEntity<List<Autor>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(autoresService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Autor> buscar(@PathVariable("id") Long id){
		return ResponseEntity.status(HttpStatus.OK).body(autoresService.buscar(id));
	}

}
