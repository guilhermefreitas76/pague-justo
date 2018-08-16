package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paguejusto.domain.Pagamento;
import br.com.paguejusto.repositories.PagamentoRepository;
import br.com.paguejusto.services.exceptions.PagueJustotNotFoundException;

@Service("pagamentoService")
public class PagamentoServiceImpl implements PagamentoService {

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Override
	public Optional<Pagamento> findById(Long id) {
		
		Optional<Pagamento> pagamento = pagamentoRepository.findById(id);
		
		if (pagamento==null) {
			throw new PagueJustotNotFoundException("Objeto não encontrado! id: " + id + "Tipo: " + Pagamento.class.getName());
		}
		return pagamento;
	}

	@Override
	public void saveAll(List<Pagamento> pagamentos) {
		pagamentoRepository.saveAll(pagamentos);
		
	}

}
