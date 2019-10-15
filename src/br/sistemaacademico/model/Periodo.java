package br.sistemaacademico.model;

import java.io.Serializable;
import java.lang.Integer;
import java.util.List;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Periodo
 *
 */
@Entity

public class Periodo implements Serializable {

	   
	@Id
	private Integer id;
	
	@Column
	private Integer numero;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "periodo_disciplina", joinColumns = { 
			@JoinColumn(name = "id_periodo") }, inverseJoinColumns = {
			@JoinColumn(name = "id_disciplina") })
	private List<Disciplina> disciplina;
	
	private static final long serialVersionUID = 1L;

	public Periodo() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public List<Disciplina> getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(List<Disciplina> disciplina) {
		this.disciplina = disciplina;
	}
   
}
