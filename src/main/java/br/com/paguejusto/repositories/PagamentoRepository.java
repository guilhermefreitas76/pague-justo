package br.com.paguejusto.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.paguejusto.domain.Pagamento;

@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Long>{

	public abstract Optional<Pagamento> findById(Long id);
	
}
