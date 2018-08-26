package br.com.paguejusto.services;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.paguejusto.domain.ItemPedido;
import br.com.paguejusto.domain.PagamentoComBoleto;
import br.com.paguejusto.domain.Pedido;
import br.com.paguejusto.domain.enums.EstadoPagamento;
import br.com.paguejusto.repositories.PedidoRepository;
import br.com.paguejusto.services.exceptions.PagueJustotNotFoundException;

@Service("pedidoService")
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@Autowired
	private ItemPedidoService itemPedidoService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ClienteService clienteService;
	

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
	
	@Transactional
	public Pedido save(Pedido pedido) {
		pedido.setId(null);
		pedido.setInstante(new Date());
		pedido.setCliente(clienteService.findById(pedido.getCliente().getId()));
		
		pedido.getPagamento().setEstadoPagamento(EstadoPagamento.PENDENTE);
		pedido.getPagamento().setPedido(pedido);
		if (pedido.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) pedido.getPagamento();
			
			//Este serviço foi criado para simular uma data de pagamento de boleto...porem na vida real posso utilizar um webservice nessa chamada...
			boletoService.preencherPagamentoComBoleto(pagto, pedido.getInstante());
		}
		
		pedido = pedidoRepository.save(pedido);
		
		pagamentoService.save(pedido.getPagamento());
		
		for (ItemPedido itemPedido : pedido.getItensPedido()) {
			//Quando for dinamico...mudar o desconto..
			itemPedido.setDesconto(new BigDecimal(0.0));
			itemPedido.setProduto(produtoService.findById(itemPedido.getProduto().getId()));
			itemPedido.setPreco(itemPedido.getProduto().getPreco());
			itemPedido.setPedido(pedido);
		
		}
		itemPedidoService.saveAll(pedido.getItensPedido());
		
		System.out.println(pedido);
		
		return pedido;
	}

}
