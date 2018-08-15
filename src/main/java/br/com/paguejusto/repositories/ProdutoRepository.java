package br.com.paguejusto.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.paguejusto.domain.Produto;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long>{

	public abstract Optional<Produto> findById(Long id);
	
}
