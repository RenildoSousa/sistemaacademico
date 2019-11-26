package br.unitins.ejb;

import br.unitins.model.Disciplina;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateful
public class DisciplinaEJB {
    @PersistenceContext
    private EntityManager em;

    public void insert(Disciplina disciplina) {
        em.persist(disciplina);
    }

    public void update(Disciplina disciplina) {
        em.merge(disciplina);
    }

    public void delete(Disciplina disciplina) {
        Disciplina tmpDisciplina = load(disciplina.getId());
        em.remove(tmpDisciplina);
    }

    public Disciplina load(Integer id) {
        return em.find(Disciplina.class, id);
    }

    public List<Disciplina> findAll() {
        return em.createQuery("select dp from Disciplina dp", Disciplina.class).getResultList();
    }
}