package br.com.paguejusto.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.paguejusto.domain.Cidade;

@Repository
public interface CidadeRepository extends CrudRepository<Cidade, Long>{

	public abstract Optional<Cidade> findById(Long id);
	
}
