package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paguejusto.domain.Endereco;
import br.com.paguejusto.repositories.EnderecoRepository;
import br.com.paguejusto.services.exceptions.PagueJustotNotFoundException;

@Service("enderecoService")
public class EnderecoServiceImpl implements EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public Optional<Endereco> findById(Long id) {

		Optional<Endereco> endereco = enderecoRepository.findById(id);

		if (endereco == null) {
			throw new PagueJustotNotFoundException(
					"Objeto não encontrado! id: " + id + "Tipo: " + Endereco.class.getName());
		}
		return endereco;
	}

	@Override
	public void saveAll(List<Endereco> enderecos) {
		enderecoRepository.saveAll(enderecos);

	}

}
