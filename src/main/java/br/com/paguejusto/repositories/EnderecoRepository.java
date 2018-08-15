package br.com.paguejusto.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.paguejusto.domain.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Long>{

	public abstract Optional<Endereco> findById(Long id);
	
}
