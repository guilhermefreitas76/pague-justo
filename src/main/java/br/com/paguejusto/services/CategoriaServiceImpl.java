package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paguejusto.domain.Categoria;
import br.com.paguejusto.repositories.CategoriaRepository;
import br.com.paguejusto.services.exceptions.PagueJustotNotFoundException;

@Service("categoriaService")
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Optional<Categoria> findById(Long id) {
		
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		
		if (categoria==null) {
			throw new PagueJustotNotFoundException("Objeto não encontrado! id: " + id + "Tipo: " + Categoria.class.getName());
		}
		return categoria;
	}

	@Override
	public void saveAll(List<Categoria> categorias) {
		categoriaRepository.saveAll(categorias);
		
	}

}
