package br.unitins.ejb;

import br.unitins.model.Disciplina;
import br.unitins.model.Periodo;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class PeriodoEJB {
    @PersistenceContext
    private EntityManager em;

    public void insert(Periodo periodo) {
        em.persist(periodo);
    }

    public void update(Periodo periodo) {
        em.merge(periodo);
    }

    public void delete(Periodo periodo) {
        Periodo tmpPeriodo = load(periodo.getId());
        em.remove(tmpPeriodo);
    }

    public Periodo load(Integer id) {
        return em.find(Periodo.class, id);
    }

    public List<Periodo> findAll() {
        return em.createQuery("select pd from Periodo pd", Periodo.class).getResultList();
    }

    private void preencheDisciplina(Periodo periodo, List<Disciplina> disciplinas) {
        List<Disciplina> disciplinasBD = new ArrayList<>();
        for (Disciplina disciplina : disciplinas) {
            disciplinasBD.add(em.find(Disciplina.class, disciplina.getId()));
        }
        periodo.setDisciplinas(disciplinasBD);
    }

}