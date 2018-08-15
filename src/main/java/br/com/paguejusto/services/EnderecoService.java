package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import br.com.paguejusto.domain.Endereco;


public interface EnderecoService {
	
	public abstract Optional<Endereco> findById(Long id);
	
	public abstract void saveAll(List<Endereco> enderecos);

}
