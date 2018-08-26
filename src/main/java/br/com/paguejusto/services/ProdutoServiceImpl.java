package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.paguejusto.domain.Categoria;
import br.com.paguejusto.domain.Produto;
import br.com.paguejusto.repositories.CategoriaRepository;
import br.com.paguejusto.repositories.ProdutoRepository;
import br.com.paguejusto.services.exceptions.PagueJustotNotFoundException;

@Service("produtoService")
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Produto findById(Long id) {

		Optional<Produto> produto = produtoRepository.findById(id);

		if (produto.isPresent()) {

			return produto.get();
		}

		else {
			throw new PagueJustotNotFoundException(
					"Objeto não encontrado! id: " + id + "Tipo: " + Produto.class.getName());
		}

	}

	@Override
	public void saveAll(List<Produto> produtos) {
		produtoRepository.saveAll(produtos);

	}

	@Override
	public Page<Produto> search(String nome, List<Long> ids, Integer page, Integer linesPerPage, String orderBy,
			String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		List<Categoria> categorias = (List<Categoria>) categoriaRepository.findAllById(ids);

		return produtoRepository.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
	}

}
