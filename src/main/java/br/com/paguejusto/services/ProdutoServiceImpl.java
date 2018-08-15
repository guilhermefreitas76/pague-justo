package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paguejusto.domain.Produto;
import br.com.paguejusto.repositories.ProdutoRepository;

@Service("produtoService")
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public Optional<Produto> findById(Long id) {

		return produtoRepository.findById(id);
	}

	@Override
	public void saveAll(List<Produto> produtos) {
		produtoRepository.saveAll(produtos);
		
	}

}
