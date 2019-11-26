package br.unitins.ejb;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.unitins.model.Aluno;

import java.util.List;

@Stateful
public class AlunoEJB {
    @PersistenceContext
    private EntityManager em;

    public void insert(Aluno aluno) {
        em.persist(aluno);
    }

    public void update(Aluno aluno) {
        em.merge(aluno);
    }

    public void delete(Aluno aluno) {
        Aluno tmpAluno = load(aluno.getId());
        em.remove(tmpAluno);
    }

    public Aluno load(Integer id) {
        return em.find(Aluno.class, id);
    }

    public List<Aluno> findAll() {
        return em.createQuery("select al from Aluno al", Aluno.class).getResultList();
    }
}