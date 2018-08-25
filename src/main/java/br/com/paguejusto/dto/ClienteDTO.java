package br.com.paguejusto.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.paguejusto.domain.Cliente;
import br.com.paguejusto.validator.ClienteUpdate;

@ClienteUpdate
public class ClienteDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length (min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres!")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length (min=5, max=80, message="O tamanho deve ser entre 5 e 100 caracteres!")
	@Email (message="E-mail inválido!")
	private String email;
	
	public ClienteDTO() {
		
	}
	
	public ClienteDTO(Cliente cliente) {
		this.id=cliente.getId();
		this.nome=cliente.getNome();
		this.email=cliente.getEmail();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
