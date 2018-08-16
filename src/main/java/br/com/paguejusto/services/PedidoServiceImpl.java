package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paguejusto.domain.Pedido;
import br.com.paguejusto.repositories.PedidoRepository;
import br.com.paguejusto.services.exceptions.PagueJustotNotFoundException;

@Service("pedidoService")
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Override
	public Optional<Pedido> findById(Long id) {
		
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		
		if (pedido==null) {
			throw new PagueJustotNotFoundException("Objeto não encontrado! id: " + id + "Tipo: " + Pedido.class.getName());
		}
		return pedido;
	}

	@Override
	public void saveAll(List<Pedido> pedidos) {
		pedidoRepository.saveAll(pedidos);
		
	}

}
