package br.com.paguejusto.services;

import java.util.Optional;

import br.com.paguejusto.domain.Categoria;


public interface CategoriaService {
	
	public abstract Optional<Categoria> findById(Long id);

}
