package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paguejusto.domain.Cidade;
import br.com.paguejusto.repositories.CidadeRepository;
import br.com.paguejusto.services.exceptions.PagueJustotNotFoundException;

@Service("cidadeService")
public class CidadeServiceImpl implements CidadeService {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Override
	public Optional<Cidade> findById(Long id) {
		
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		
		if (cidade==null) {
			throw new PagueJustotNotFoundException("Objeto não encontrado! id: " + id + "Tipo: " + Cidade.class.getName());
		}
		return cidade;
	}

	@Override
	public void saveAll(List<Cidade> cidades) {
		cidadeRepository.saveAll(cidades);
		
	}

}
