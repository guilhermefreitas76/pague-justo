package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import br.com.paguejusto.domain.Pagamento;


public interface PagamentoService {
	
	public abstract Optional<Pagamento> findById(Long id);
	
	public abstract void saveAll(List<Pagamento> pagamentos);

}
