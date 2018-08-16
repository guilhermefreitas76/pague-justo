package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.paguejusto.domain.Categoria;


public interface CategoriaService {
	
	public abstract Optional<Categoria> findById(Long id);
	
	public abstract void saveAll(List<Categoria> categorias);

	public abstract Categoria insert(Categoria categoria);
	
	public abstract Categoria update(Categoria categoria);
	
	public abstract void deleteById(Long id);
	
	public abstract List<Categoria> findAll();
	
	public abstract Page<Categoria> findPage(Integer page,Integer linesPerPage,String orderBy, String direction);
		
	
}
