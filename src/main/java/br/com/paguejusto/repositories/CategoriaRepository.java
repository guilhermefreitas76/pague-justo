package br.com.paguejusto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.paguejusto.domain.Categoria;

@Repository
public interface CategoriaRepository extends PagingAndSortingRepository<Categoria, Long>{

	public abstract Optional<Categoria> findById(Long id);
	
	public abstract List<Categoria> findAll();
	
}
