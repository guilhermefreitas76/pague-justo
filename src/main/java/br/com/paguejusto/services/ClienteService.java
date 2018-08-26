package br.com.paguejusto.services;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.paguejusto.domain.Cliente;
import br.com.paguejusto.dto.ClienteDTO;
import br.com.paguejusto.dto.ClienteNewDTO;


public interface ClienteService {
	
	public abstract Cliente findById(Long id);
	
	public abstract void saveAll(List<Cliente> clientes);
	
	public abstract Cliente insert(Cliente cliente);
	
	public abstract Cliente update(Cliente cliente);
	
	public abstract void deleteById(Long id);
	
	public abstract List<Cliente> findAll();
	
	public abstract Page<Cliente> findPage(Integer page,Integer linesPerPage,String orderBy, String direction);
		
	public abstract Cliente fromDTO(ClienteDTO clienteDTO);
	
	public abstract Cliente fromDTO(ClienteNewDTO clienteNewDTO);
	
	public abstract Cliente findByEmail(String email);
	

}
