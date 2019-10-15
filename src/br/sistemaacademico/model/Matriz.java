package br.sistemaacademico.model;

import br.sistemaacademico.model.Curso;
import java.io.Serializable;
import java.lang.Integer;
import java.util.List;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Matriz
 *
 */
@Entity

public class Matriz implements Serializable {

	   
	@Id
	private Integer id;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "matriz_periodo", joinColumns = { 
			@JoinColumn(name = "id_matriz") }, inverseJoinColumns = {
			@JoinColumn(name = "id_periodo") })
	private List<Curso> periodo;
	
	@ManyToOne
	@JoinColumn(name = "curso_id_fk")
	private Curso curso;
	
	private static final long serialVersionUID = 1L;

	public Matriz() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public List<Curso> getPeriodo() {
		return this.periodo;
	}

	public void setPeriodo(List<Curso> periodo) {
		this.periodo = periodo;
	}   
	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
   
}
