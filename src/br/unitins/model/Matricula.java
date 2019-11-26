package br.unitins.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private DisciplinaOfertada disciplina;

    public Matricula() {
        super();
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public DisciplinaOfertada getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(DisciplinaOfertada disciplina) {
        this.disciplina = disciplina;
    }
}
