package br.com.paguejusto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.paguejusto.domain.Cliente;

@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long>{

	public abstract Optional<Cliente> findById(Long id);
	
	public abstract List<Cliente> findAll();
	
}
