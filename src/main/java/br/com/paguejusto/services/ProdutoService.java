package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.paguejusto.domain.Produto;


public interface ProdutoService {
	
	public abstract Optional<Produto> findById(Long id);
	
	public abstract void saveAll(List<Produto> produtos);
	
	public abstract Page<Produto> search(String nome, List<Long> ids,Integer page, Integer linesPerPage, String orderBy, String direction); 
	
	
}
