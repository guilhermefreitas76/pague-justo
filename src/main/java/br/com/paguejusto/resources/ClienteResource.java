package br.com.paguejusto.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.paguejusto.domain.Cliente;
import br.com.paguejusto.services.ClienteService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Cliente find(@PathVariable Long id) {
		try {
			Optional<Cliente> cliente = clienteService.findById(id);

			return cliente.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado id: " + id + ", Tipo: " + Cliente.class.getName()));
		} catch (ObjectNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
