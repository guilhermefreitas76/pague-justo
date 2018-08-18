package br.com.paguejusto.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Abstract implements Serializable{

	/**
	 * @author Guilherme Freitas
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	@Column(name = "data_hora_alteracao")
	private Timestamp  dataHoraAlteracao;
	
	@Column(name = "data_hora_criacao")
	private Timestamp  dataHoraCriacao;
	
	@Column(name = "ativo")
	private Boolean ativo;

	@Column(name = "acesso_externo_ip")
	private String acessoExternoIP;

	@Column(name = "data_hora_inicio_sessao_usuario")
	private Timestamp  dataHoraInicioSessaoUsuario;

	@Column(name = "data_hora_termino_sessao_usuario")
	private Timestamp  dataHoraTerminoSessaoUsuario;
	
	@Column(name = "nome_da_classe")
	private String nomeDaClasse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getDataHoraAlteracao() {
		return dataHoraAlteracao;
	}

	public void setDataHoraAlteracao(Timestamp dataHoraAlteracao) {
		this.dataHoraAlteracao = dataHoraAlteracao;
	}

	public Timestamp getDataHoraCriacao() {
		return dataHoraCriacao;
	}

	public void setDataHoraCriacao(Timestamp dataHoraCriacao) {
		this.dataHoraCriacao = dataHoraCriacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public String getAcessoExternoIP() {
		return acessoExternoIP;
	}

	public void setAcessoExternoIP(String acessoExternoIP) {
		this.acessoExternoIP = acessoExternoIP;
	}

	public Timestamp getDataHoraInicioSessaoUsuario() {
		return dataHoraInicioSessaoUsuario;
	}

	public void setDataHoraInicioSessaoUsuario(Timestamp dataHoraInicioSessaoUsuario) {
		this.dataHoraInicioSessaoUsuario = dataHoraInicioSessaoUsuario;
	}

	public Timestamp getDataHoraTerminoSessaoUsuario() {
		return dataHoraTerminoSessaoUsuario;
	}

	public void setDataHoraTerminoSessaoUsuario(Timestamp dataHoraTerminoSessaoUsuario) {
		this.dataHoraTerminoSessaoUsuario = dataHoraTerminoSessaoUsuario;
	}

	public String getNomeDaClasse() {
		return nomeDaClasse;
	}

	public void setNomeDaClasse(String nomeDaClasse) {
		this.nomeDaClasse = nomeDaClasse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Abstract other = (Abstract) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
