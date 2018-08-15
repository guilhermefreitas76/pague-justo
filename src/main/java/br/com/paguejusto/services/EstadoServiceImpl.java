package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paguejusto.domain.Estado;
import br.com.paguejusto.repositories.EstadoRepository;
import br.com.paguejusto.services.exceptions.PagueJustotNotFoundException;

@Service("estadoService")
public class EstadoServiceImpl implements EstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	@Override
	public Optional<Estado> findById(Long id) {
		
		Optional<Estado> estado = estadoRepository.findById(id);
		
		if (estado==null) {
			throw new PagueJustotNotFoundException("Objeto não encontrado! id: " + id + "Tipo: " + Estado.class.getName());
		}
		return estado;
	}

	@Override
	public void saveAll(List<Estado> estados) {
		estadoRepository.saveAll(estados);
		
	}

}
