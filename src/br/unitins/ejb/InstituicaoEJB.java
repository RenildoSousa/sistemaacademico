package br.unitins.ejb;

import br.unitins.model.Instituicao;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateful
public class InstituicaoEJB {
    @PersistenceContext
    private EntityManager em;

    public void insert(Instituicao instituicao) {
        em.persist(instituicao);
    }

    public void update(Instituicao instituicao) {
        em.merge(instituicao);
    }

    public void delete(Instituicao instituicao) {
        Instituicao tmpInstituicao = load(instituicao.getIdInstituicao());
        em.remove(tmpInstituicao);
    }

    public Instituicao load(Integer id) {
        return em.find(Instituicao.class, id);
    }

    public List<Instituicao> findAll() {
        return em.createQuery("select tp from Instituicao tp", Instituicao.class).getResultList();
    }
}