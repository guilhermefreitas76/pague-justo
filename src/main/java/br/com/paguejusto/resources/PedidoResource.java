package br.com.paguejusto.resources;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.paguejusto.domain.Pedido;
import br.com.paguejusto.services.PedidoService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService pedidoService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Pedido find(@PathVariable Long id) {
		try {
			Optional<Pedido> pedito = pedidoService.findById(id);

			return pedito.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado id: " + id + ", Tipo: " + Pedido.class.getName()));
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Pedido pedido) {

		pedido = pedidoService.save(pedido);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getId()).toUri();

		return ResponseEntity.created(uri).build();

	}

}
