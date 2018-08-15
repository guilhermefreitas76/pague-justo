package br.com.paguejusto.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.paguejusto.domain.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{

	public abstract Optional<Cliente> findById(Long id);
	
}
