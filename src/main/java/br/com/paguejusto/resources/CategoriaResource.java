package br.com.paguejusto.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.paguejusto.domain.Categoria;
import br.com.paguejusto.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Categoria find(@PathVariable Long id) {

		Optional<Categoria> categoria = categoriaService.findById(id);
		return categoria.orElse(null);
	}

}
