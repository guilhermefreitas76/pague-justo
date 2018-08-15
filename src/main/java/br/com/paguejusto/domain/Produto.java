package br.com.paguejusto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "tb_produto")
public class Produto extends Abstract {

	private static final long serialVersionUID = 1L;

	private String nome;
	private BigDecimal preco;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name="produto_categoria",joinColumns=@JoinColumn(name="produto_id"),
	inverseJoinColumns=@JoinColumn(name="categoria_id"))
	private List<Categoria> categorias = new ArrayList<>();

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
}
