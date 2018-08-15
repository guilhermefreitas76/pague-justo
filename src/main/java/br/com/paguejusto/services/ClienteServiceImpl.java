package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paguejusto.domain.Cliente;
import br.com.paguejusto.repositories.ClienteRepository;
import br.com.paguejusto.services.exceptions.PagueJustotNotFoundException;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Optional<Cliente> findById(Long id) {
		
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if (cliente==null) {
			throw new PagueJustotNotFoundException("Objeto não encontrado! id: " + id + "Tipo: " + Cliente.class.getName());
		}
		return cliente;
	}

	@Override
	public void saveAll(List<Cliente> clientes) {
		clienteRepository.saveAll(clientes);
		
	}

}
