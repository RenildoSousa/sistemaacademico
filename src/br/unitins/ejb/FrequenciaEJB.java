package br.unitins.ejb;

import br.unitins.model.Frequencia;
import br.unitins.model.Matricula;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateful
public class FrequenciaEJB {
    @PersistenceContext
    private EntityManager em;

    public void insert(Frequencia frequencia, Integer idMatricula) {
        preencheMatricula(frequencia, idMatricula);
        em.persist(frequencia);
    }

    public void update(Frequencia frequencia, Integer idMatricula) {
        preencheMatricula(frequencia, idMatricula);
        em.merge(frequencia);
    }

    public void delete(Frequencia frequencia) {
        Frequencia tmpFrequencia = load(frequencia.getId());
        em.remove(tmpFrequencia);
    }

    public Frequencia load(Integer id) {
        return em.find(Frequencia.class, id);
    }

    public List<Frequencia> findAll() {
        return em.createQuery("select fq from Frequencia fq", Frequencia.class).getResultList();
    }

    private void preencheMatricula(Frequencia frequencia, Integer idMatricula) {
        frequencia.setMatricula(em.find(Matricula.class, idMatricula));
    }
}