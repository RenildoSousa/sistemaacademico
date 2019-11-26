package br.unitins.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.ejb.DisciplinaEJB;
import br.unitins.ejb.PeriodoEJB;
import br.unitins.model.Disciplina;
import br.unitins.model.Periodo;

@Named
@SessionScoped
public class PeriodoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private PeriodoEJB periodoEJB;

	@EJB
	private DisciplinaEJB disciplinaEJB;

	private Periodo periodo;

	private List<Periodo> periodos;

	private Integer idPesquisa;

	private List<Disciplina> disciplinas;

	private List<Integer> idDisciplina = new ArrayList<Integer>();

	@PostConstruct
	public void init() {
		findAll();
		findAllDisciplinas();
	}

	private void findAllDisciplinas() {
		disciplinas = disciplinaEJB.findAll();
	}

	public void insert() {
		periodo.setDisciplinas(getDisciplinas());
		periodoEJB.insert(periodo);
		clean();
		findAll();
	}

	private void findAll() {
		periodos = periodoEJB.findAll();
	}

	public void update() {
		periodo.setDisciplinas(getDisciplinas());
		periodoEJB.update(periodo);
		clean();
		findAll();
	}

	public void delete() {
		periodoEJB.delete(periodoEJB.load(idPesquisa));
		clean();
		findAll();
	}

	public void pesquisar() {
		periodo = periodoEJB.load(idPesquisa);
	}

	public void clean() {
		periodo = new Periodo();
	}

	public Periodo getPeriodo() {
		if (periodo == null) {
			periodo = new Periodo();
		}
		return periodo;
	}

	public void setPeriodo(Periodo entity) {
		this.periodo = entity;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}

	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	public List<Disciplina> getDisciplinas() {
		disciplinas.clear();
		for (int i = 0; i < idDisciplina.size(); i++) {
			disciplinas.add(disciplinaEJB.load(idDisciplina.get(i)));
		}

		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Integer> getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(List<Integer> idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

}