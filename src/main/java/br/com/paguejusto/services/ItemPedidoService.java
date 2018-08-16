package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import br.com.paguejusto.domain.ItemPedido;


public interface ItemPedidoService {
	
	public abstract Optional<ItemPedido> findById(Long id);
	
	public abstract void saveAll(List<ItemPedido> itenspedido);

}
