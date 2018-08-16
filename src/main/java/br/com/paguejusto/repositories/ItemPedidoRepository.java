package br.com.paguejusto.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.paguejusto.domain.ItemPedido;

@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Long>{

	public abstract Optional<ItemPedido> findById(Long id);
	
}
