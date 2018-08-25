package br.com.paguejusto.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.paguejusto.domain.Categoria;
import br.com.paguejusto.domain.Produto;
import br.com.paguejusto.domain.Produto;
import br.com.paguejusto.dto.ProdutoDTO;
import br.com.paguejusto.services.ProdutoService;
import br.com.paguejusto.validator.utils.URL;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Produto find(@PathVariable Long id) {
		try {
			Optional<Produto> produto = produtoService.findById(id);

			return produto.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado id: " + id + ", Tipo: " + Produto.class.getName()));
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<ProdutoDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "nome", defaultValue = "") String nome,
			@RequestParam(value = "categorias", defaultValue = "") String categorias,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		
		List<Long> ids = URL.decodeIntList(categorias);

		Page<Produto> listProduto = produtoService.search(URL.decodeParam(nome), ids, page, linesPerPage, orderBy, direction);

		Page<ProdutoDTO> listaProdutoDTO = listProduto.map(obj -> new ProdutoDTO(obj));

		return ResponseEntity.ok().body(listaProdutoDTO);
	}

}