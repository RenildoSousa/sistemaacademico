package br.sistemaacademico.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: UnidadeOrganizacional
 *
 */
@Entity

public class UnidadeOrganizacional implements Serializable {

	   
	@Id
	@GeneratedValue
	private Integer id;
	private Integer tipoDeOrganizacao;
	private String nome;


	public UnidadeOrganizacional() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Integer getTipoDeOrganizacao() {
		return this.tipoDeOrganizacao;
	}

	public void setTipoDeOrganizacao(Integer tipoDeOrganizacao) {
		this.tipoDeOrganizacao = tipoDeOrganizacao;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
   
}
