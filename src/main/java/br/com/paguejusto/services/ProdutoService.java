package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import br.com.paguejusto.domain.Produto;


public interface ProdutoService {
	
	public abstract Optional<Produto> findById(Long id);
	
	public abstract void saveAll(List<Produto> produtos);

}