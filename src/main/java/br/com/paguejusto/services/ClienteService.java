package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import br.com.paguejusto.domain.Cliente;


public interface ClienteService {
	
	public abstract Optional<Cliente> findById(Long id);
	
	public abstract void saveAll(List<Cliente> clientes);

}
