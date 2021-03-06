package br.com.paguejusto.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.paguejusto.domain.ItemPedido;
import br.com.paguejusto.repositories.ItemPedidoRepository;
import br.com.paguejusto.services.exceptions.PagueJustotNotFoundException;

@Service("itemPedidoService")
public class ItemPedidoServiceImpl implements ItemPedidoService {

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	public Optional<ItemPedido> findById(Long id) {
		
		Optional<ItemPedido> itemPedido = itemPedidoRepository.findById(id);
		
		if (itemPedido==null) {
			throw new PagueJustotNotFoundException("Objeto não encontrado! id: " + id + "Tipo: " + ItemPedido.class.getName());
		}
		return itemPedido;
	}

	@Override
	@Transactional
	public void saveAll(Set<ItemPedido> itensPedidos) {
		itemPedidoRepository.saveAll(itensPedidos);
		
	}

}
