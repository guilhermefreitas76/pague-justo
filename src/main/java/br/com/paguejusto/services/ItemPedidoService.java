package br.com.paguejusto.services;

import java.util.Optional;
import java.util.Set;

import br.com.paguejusto.domain.ItemPedido;


public interface ItemPedidoService {
	
	public abstract Optional<ItemPedido> findById(Long id);
	
	public abstract void saveAll(Set<ItemPedido> itenspedido);

}
