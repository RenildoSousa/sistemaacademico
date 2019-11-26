package br.unitins.ejb;

import br.unitins.model.Aluno;
import br.unitins.model.DisciplinaOfertada;
import br.unitins.model.Matricula;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateful
public class MatriculaEJB {
    @PersistenceContext
    private EntityManager em;

    public void insert(Matricula matricula, Integer idAluno, Integer idDisciplinaOF) {
        preencheRelacoes(idAluno, matricula, idDisciplinaOF);
        em.persist(matricula);
    }


    public void update(Matricula matricula, Integer idAluno, Integer idDisciplinaOF) {
        preencheRelacoes(idAluno, matricula, idDisciplinaOF);
        em.merge(matricula);
    }

    public void delete(Matricula matricula) {
        Matricula tmpMatricula = load(matricula.getId());
        em.remove(tmpMatricula);
    }

    public Matricula load(Integer id) {
        return em.find(Matricula.class, id);
    }

    public List<Matricula> findAll() {
        return em.createQuery("select mt from Matricula mt", Matricula.class).getResultList();
    }

    private void preencheRelacoes(Integer idAluno, Matricula matricula, Integer idDisciplinaOF) {
        matricula.setAluno(em.find(Aluno.class, idAluno));
        matricula.setDisciplina(em.find(DisciplinaOfertada.class, idDisciplinaOF));
    }

}