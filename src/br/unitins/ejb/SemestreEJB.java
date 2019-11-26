package br.unitins.ejb;

import br.unitins.model.Semestre;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateful
public class SemestreEJB {
    @PersistenceContext
    private EntityManager em;

    public void insert(Semestre semestre) {
        em.persist(semestre);
    }

    public void update(Semestre semestre) {
        em.merge(semestre);
    }

    public void delete(Semestre semestre) {
        Semestre tmpSemestre = load(semestre.getId());
        em.remove(tmpSemestre);
    }

    public Semestre load(Integer id) {
        return em.find(Semestre.class, id);
    }

    public List<Semestre> findAll() {
        return em.createQuery("select sm from Semestre sm", Semestre.class).getResultList();
    }
}