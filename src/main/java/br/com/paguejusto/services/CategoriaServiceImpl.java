package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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

		if (categoria == null) {
			throw new PagueJustotNotFoundException(
					"Objeto não encontrado! id: " + id + "Tipo: " + Categoria.class.getName());
		}
		return categoria;
	}

	@Override
	public void saveAll(List<Categoria> categorias) {
		categoriaRepository.saveAll(categorias);

	}

	@Override
	public Categoria insert(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}

	@Override
	public Categoria update(Categoria categoria) {
		findById(categoria.getId());
		return categoriaRepository.save(categoria);

	}

	@Override
	public void deleteById(Long id) {
		try {
			categoriaRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir uma categoria que possui produtos!");
		}
	}

	@Override
	public List<Categoria> findAll() {

		return categoriaRepository.findAll();
	}

	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return categoriaRepository.findAll(pageRequest);
	}

}
