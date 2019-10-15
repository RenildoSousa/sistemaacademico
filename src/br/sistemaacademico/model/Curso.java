package br.sistemaacademico.model;

import br.sistemaacademico.model.UnidadeOrganizacional;
import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Curso
 *
 */
@Entity

public class Curso implements Serializable {

	   
	@Id
	private Integer id;
	@Column
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "unidadeOrganizacional_id_fk")
	private UnidadeOrganizacional organizacao;
	
	private static final long serialVersionUID = 1L;

	public Curso() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public UnidadeOrganizacional getOrganizacao() {
		return this.organizacao;
	}

	public void setOrganizacao(UnidadeOrganizacional organizacao) {
		this.organizacao = organizacao;
	}
   
}
