package com.trisoft.socialbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trisoft.socialbooks.domain.Livro;

public interface LivrosRepository extends JpaRepository<Livro, Long>{

}
