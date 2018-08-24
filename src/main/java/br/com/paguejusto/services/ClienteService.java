package br.com.paguejusto.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.paguejusto.domain.Cliente;
import br.com.paguejusto.dto.ClienteDTO;


public interface ClienteService {
	
	public abstract Optional<Cliente> findById(Long id);
	
	public abstract void saveAll(List<Cliente> clientes);
	
	public abstract Cliente insert(Cliente cliente);
	
	public abstract Cliente update(Cliente cliente);
	
	public abstract void deleteById(Long id);
	
	public abstract List<Cliente> findAll();
	
	public abstract Page<Cliente> findPage(Integer page,Integer linesPerPage,String orderBy, String direction);
		
	public abstract Cliente fromDTO(ClienteDTO clienteDTO);
	

}
