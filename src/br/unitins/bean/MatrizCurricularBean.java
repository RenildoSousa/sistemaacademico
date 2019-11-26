package br.unitins.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.unitins.ejb.MatrizCurricularEJB;
import br.unitins.ejb.PeriodoEJB;
import br.unitins.model.MatrizCurricular;
import br.unitins.model.Periodo;

@Named
@SessionScoped
public class MatrizCurricularBean implements Serializable {

	private static final long serialVersionUID = 4482986430991847301L;

	@EJB
	private MatrizCurricularEJB matrizCurricularEJB;

	@EJB
	private PeriodoEJB periodoEJB;

	private MatrizCurricular matrizCurricular;

	private List<MatrizCurricular> matrizesCurriculares;

	private Integer idPesquisa;
	private Integer idCurso;
	private List<Periodo> periodos;

	private List<Integer> idPeriodo = new ArrayList<Integer>();

	@PostConstruct
	public void init() {
		findAll();
		findAllPeriodos();
	}

	private void findAllPeriodos() {
		periodos = periodoEJB.findAll();
	}

	public void insert() {
		matrizCurricularEJB.insert(matrizCurricular, idCurso, periodos);
		clean();
		findAll();
	}

	private void findAll() {
		matrizesCurriculares = matrizCurricularEJB.findAll();
	}

	public void update() {
		matrizCurricularEJB.update(matrizCurricular, idCurso, periodos);
		clean();
		findAll();
	}

	public String delete() {
		matrizCurricularEJB.delete(matrizCurricularEJB.load(idPesquisa));
		clean();
		matrizesCurriculares = matrizCurricularEJB.findAll();
		return null;
	}

	public void pesquisar() {
		matrizCurricular = matrizCurricularEJB.load(idPesquisa);
	}

	public void clean() {
		matrizCurricular = new MatrizCurricular();
	}

	public MatrizCurricular getMatrizCurricular() {
		if (matrizCurricular == null) {
			matrizCurricular = new MatrizCurricular();
		}
		return matrizCurricular;
	}

	public void setMatrizCurricular(MatrizCurricular matrizCurricular) {
		this.matrizCurricular = matrizCurricular;
	}

	public List<MatrizCurricular> getMatrizesCurriculares() {
		return matrizesCurriculares;
	}

	public void setMatrizesCurriculares(List<MatrizCurricular> matrizesCurriculares) {
		this.matrizesCurriculares = matrizesCurriculares;
	}

	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}

	public List<Integer> getIdPeriodo() {
		return idPeriodo;
	}

	public void setIdPeriodo(List<Integer> idPeriodo) {
		this.idPeriodo = idPeriodo;
	}

}
