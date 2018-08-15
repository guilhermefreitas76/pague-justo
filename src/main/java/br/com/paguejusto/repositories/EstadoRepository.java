package br.com.paguejusto.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.paguejusto.domain.Estado;

@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long>{

	public abstract Optional<Estado> findById(Long id);
	
}
