package br.com.paguejusto.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.paguejusto.domain.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long>{

	public abstract Optional<Pedido> findById(Long id);
	
}
