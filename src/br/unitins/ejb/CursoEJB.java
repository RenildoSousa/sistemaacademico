package br.unitins.ejb;

import br.unitins.model.Curso;
import br.unitins.model.Instituicao;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

;

@Stateful
public class CursoEJB {

    @PersistenceContext
    private EntityManager em;

    public void insert(Curso curso, Integer idInstituicao) {
        curso.setInstituicao(em.find(Instituicao.class, idInstituicao));
        em.persist(curso);
    }

    public void update(Curso curso, Integer idInstituicao) {
        curso.setInstituicao(em.find(Instituicao.class, idInstituicao));
        em.merge(curso);
    }

    public void delete(Curso curso) {
        curso = load(curso.getId());
        em.remove(curso);
    }

    public Curso load(Integer id) {
        return em.find(Curso.class, id);
    }

    public List<Curso> findAll() {
        return em.createQuery("select c from Curso c", Curso.class).getResultList();
    }

}