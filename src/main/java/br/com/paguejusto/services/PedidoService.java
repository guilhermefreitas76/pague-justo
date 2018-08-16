package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import br.com.paguejusto.domain.Pedido;


public interface PedidoService {
	
	public abstract Optional<Pedido> findById(Long id);
	
	public abstract void saveAll(List<Pedido> pedidos);

}
