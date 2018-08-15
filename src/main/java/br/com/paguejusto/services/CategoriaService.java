package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import br.com.paguejusto.domain.Categoria;


public interface CategoriaService {
	
	public abstract Optional<Categoria> findById(Long id);
	
	public abstract void saveAll(List<Categoria> categorias);

}
