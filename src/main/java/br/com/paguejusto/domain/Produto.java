package br.com.paguejusto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_produto")
public class Produto extends Abstract {

	private static final long serialVersionUID = 1L;

	private String nome;
	private BigDecimal preco;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="produto_categoria",joinColumns=@JoinColumn(name="produto_id"),
	inverseJoinColumns=@JoinColumn(name="categoria_id"))
	private List<Categoria> categorias = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="id.produto")
	private Set<ItemPedido> itensPedido = new HashSet<>();
	
	@JsonIgnore
	public List<Pedido> getPedidos(){
		
		List<Pedido> listaPedidos = new ArrayList<>();
		
		for(ItemPedido item : itensPedido) {
			listaPedidos.add(item.getPedido());
		}
		
		return listaPedidos;
	}
		

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

	public Set<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(Set<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}
	
}
