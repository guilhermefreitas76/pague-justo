package br.com.paguejusto.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.paguejusto.domain.Categoria;
import br.com.paguejusto.repositories.CategoriaRepository;

@Service("categoriaService")
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public Optional<Categoria> findById(Long id) {

		return categoriaRepository.findById(id);
	}

}
