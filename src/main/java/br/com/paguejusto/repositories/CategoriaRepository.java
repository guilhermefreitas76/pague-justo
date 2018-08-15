package br.com.paguejusto.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.paguejusto.domain.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long>{

	public abstract Optional<Categoria> findById(Long id);
	
	
}
