package br.com.paguejusto.dto;

import java.io.Serializable;

import br.com.paguejusto.domain.Categoria;

public class CategoriaDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String nome;
	
	public CategoriaDTO(Categoria categoria) {
		this.id=categoria.getId();
		this.nome=categoria.getNome();
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


}
