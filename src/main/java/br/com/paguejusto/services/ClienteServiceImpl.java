package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.paguejusto.domain.Cidade;
import br.com.paguejusto.domain.Cliente;
import br.com.paguejusto.domain.Endereco;
import br.com.paguejusto.domain.enums.TipoCliente;
import br.com.paguejusto.dto.ClienteDTO;
import br.com.paguejusto.dto.ClienteNewDTO;
import br.com.paguejusto.repositories.CidadeRepository;
import br.com.paguejusto.repositories.ClienteRepository;
import br.com.paguejusto.repositories.EnderecoRepository;
import br.com.paguejusto.services.exceptions.PagueJustotNotFoundException;

@Service("clienteService")
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public Optional<Cliente> findById(Long id) {

		Optional<Cliente> cliente = clienteRepository.findById(id);

		if (cliente == null) {
			throw new PagueJustotNotFoundException(
					"Objeto não encontrado! id: " + id + "Tipo: " + Cliente.class.getName());
		}
		return cliente;
	}

	@Override
	public void saveAll(List<Cliente> clientes) {
		clienteRepository.saveAll(clientes);

	}

	@Override
	@Transactional
	public Cliente insert(Cliente cliente) {
		cliente.setId(null);
	
		cliente = clienteRepository.save(cliente);
		
		enderecoRepository.saveAll(cliente.getEnderecos());

		return cliente;

	}

	@Override
	public Cliente update(Cliente cliente) {
		Optional<Cliente> novoCliente = findById(cliente.getId());
		if (novoCliente.isPresent()) {

			updateData(novoCliente.get(), cliente);

			return clienteRepository.save(novoCliente.get());
		}
		return null;

	}

	@Override
	public void deleteById(Long id) {
		try {
			clienteRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Não é possivel excluir uma cliente que possui pedidos relacionados!");
		}
	}

	@Override
	public List<Cliente> findAll() {

		return clienteRepository.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepository.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO clienteDTO) {
		return new Cliente(clienteDTO.getId(), clienteDTO.getNome(), clienteDTO.getEmail(), null, null);

	}

	public Cliente fromDTO(ClienteNewDTO clienteNewDTO) {

		Cliente cliente = new Cliente(null, clienteNewDTO.getNome(), clienteNewDTO.getEmail(),
				clienteNewDTO.getCpfOuCnpj(), TipoCliente.toEnum(clienteNewDTO.getTipoCliente()));

		Optional<Cidade> cidade = cidadeRepository.findById(clienteNewDTO.getIdCidade());

		Endereco endereco = new Endereco(null, clienteNewDTO.getLogradouro(), clienteNewDTO.getNumero(),
				clienteNewDTO.getComplemento(), clienteNewDTO.getBairro(), clienteNewDTO.getCep(), cliente,
				cidade.get());
		cliente.getEnderecos().add(endereco);

		if (clienteNewDTO.getTelefoneResidencial() != null) {
			cliente.getTelefones().add(clienteNewDTO.getTelefoneResidencial());
		}

		if (clienteNewDTO.getTelefoneCelular() != null) {
			cliente.getTelefones().add(clienteNewDTO.getTelefoneCelular());
		}

		if (clienteNewDTO.getTelefoneComercial() != null) {
			cliente.getTelefones().add(clienteNewDTO.getTelefoneComercial());
		}

		return cliente;
	}

	private void updateData(Cliente novoCliente, Cliente cliente) {

		novoCliente.setEmail(cliente.getEmail());
		novoCliente.setNome(cliente.getNome());

	}

	@Override
	public Cliente findByEmail(String email) {
		
		return clienteRepository.findByEmail(email);
	}

}
