package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import br.com.paguejusto.domain.Estado;


public interface EstadoService {
	
	public abstract Optional<Estado> findById(Long id);
	
	public abstract void saveAll(List<Estado> estados);

}
