package br.com.paguejusto.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_estado")
public class Estado extends Abstract {

	private static final long serialVersionUID = 1L;

	private String nome;

	@OneToMany(mappedBy = "estado")
	private List<Cidade> cidades;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

}