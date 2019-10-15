package br.sistemaacademico.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Disciplina
 *
 */
@Entity

public class Disciplina implements Serializable {

	   
	@Id
	private Integer id;
	
	@Column
	private String nome;
	
	@Column
	private String cargaHoraria;
	
	private static final long serialVersionUID = 1L;

	public Disciplina() {
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
	public String getCargaHoraria() {
		return this.cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
   
}
