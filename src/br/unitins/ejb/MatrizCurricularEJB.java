package br.unitins.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Periodo;
import br.unitins.model.Curso;
import br.unitins.model.MatrizCurricular;;

@Stateful
public class MatrizCurricularEJB {

	@PersistenceContext
	private EntityManager em;

	public void insert(MatrizCurricular matrizCurricular, Integer idCurso, List<Periodo> periodos) {
		preencheMatrizCurricular(matrizCurricular, idCurso, periodos);
		em.persist(matrizCurricular);
	}

	public void update(MatrizCurricular matrizCurricular, Integer idCurso, List<Periodo> periodos) {
		preencheMatrizCurricular(matrizCurricular, idCurso, periodos);
		em.merge(matrizCurricular);
	}

	public void delete(MatrizCurricular matrizCurricular) {
		MatrizCurricular tmpMatrizCurricular = load(matrizCurricular.getId());
		em.remove(tmpMatrizCurricular);
	}

	public MatrizCurricular load(Integer id) {
		return em.find(MatrizCurricular.class, id);
	}

	public List<MatrizCurricular> findAll() {
		return em.createQuery("select mtc from MatrizCurricular mtc", MatrizCurricular.class).getResultList();
	}

	private void preencheMatrizCurricular(MatrizCurricular matrizCurricular, Integer idCurso, List<Periodo> periodos) {
		List<Periodo> periodosBD = new ArrayList<>();
		matrizCurricular.setCurso(em.find(Curso.class, idCurso));
		for (Periodo periodo : periodos) {
			periodosBD.add(em.find(Periodo.class, periodo.getId()));
		}
		matrizCurricular.setPeriodos(periodosBD);
	}
}