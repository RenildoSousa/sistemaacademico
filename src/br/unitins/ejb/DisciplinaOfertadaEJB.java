package br.unitins.ejb;

import br.unitins.model.Disciplina;
import br.unitins.model.DisciplinaOfertada;
import br.unitins.model.Professor;
import br.unitins.model.Semestre;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateful
public class DisciplinaOfertadaEJB {
    @PersistenceContext
    private EntityManager em;

    public void insert(DisciplinaOfertada disciplinaOfertada,
                       Integer idSemestre, Integer idDisciplina,
                       Integer idProfessor) {
        preencheRelacionamento(disciplinaOfertada, idSemestre, idDisciplina, idProfessor);
        em.persist(disciplinaOfertada);
    }


    public void update(DisciplinaOfertada disciplinaOfertada,
                       Integer idSemestre, Integer idDisciplina,
                       Integer idProfessor) {
        preencheRelacionamento(disciplinaOfertada, idSemestre, idDisciplina, idProfessor);
        em.merge(disciplinaOfertada);
    }

    public void delete(DisciplinaOfertada disciplinaOfertada) {
        DisciplinaOfertada tmpDisciplinaOfertada = load(disciplinaOfertada.getId());
        em.remove(tmpDisciplinaOfertada);
    }

    public DisciplinaOfertada load(Integer id) {
        return em.find(DisciplinaOfertada.class, id);
    }

    public List<DisciplinaOfertada> findAll() {
        return em.createQuery("select dsp from DisciplinaOfertada dsp", DisciplinaOfertada.class).getResultList();
    }

    private void preencheRelacionamento(DisciplinaOfertada disciplinaOfertada, Integer idSemestre, Integer idDisciplina, Integer idProfessor) {
        disciplinaOfertada.setSemestre(em.find(Semestre.class, idSemestre));
        disciplinaOfertada.setDisciplina(em.find(Disciplina.class, idDisciplina));
        disciplinaOfertada.setProfessor(em.find(Professor.class, idProfessor));
    }
}