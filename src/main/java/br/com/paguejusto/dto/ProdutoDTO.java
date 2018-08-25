package br.com.paguejusto.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.paguejusto.domain.Produto;

public class ProdutoDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length (min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres!")
	private String nome;
	private BigDecimal preco;
		
	public ProdutoDTO() {
		
	}
	
	public ProdutoDTO(Produto produto) {
		this.id=produto.getId();
		this.nome=produto.getNome();
		this.preco=produto.getPreco();
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

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
}
