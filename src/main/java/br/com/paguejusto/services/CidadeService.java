package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import br.com.paguejusto.domain.Cidade;


public interface CidadeService {
	
	public abstract Optional<Cidade> findById(Long id);
	
	public abstract void saveAll(List<Cidade> cidades);

}
