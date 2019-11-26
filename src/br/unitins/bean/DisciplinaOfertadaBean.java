package br.unitins.bean;

import br.unitins.ejb.DisciplinaOfertadaEJB;
import br.unitins.model.DisciplinaOfertada;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class DisciplinaOfertadaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private DisciplinaOfertadaEJB disciplinaOfertadaEJB;

    private DisciplinaOfertada disciplinaOfertada;

    private List<DisciplinaOfertada> disciplinaOfertadas;

    private Integer idPesquisa;
    private Integer idDisciplina;
    private Integer idSemestre;
    private Integer idProfessor;


    @PostConstruct
    public void init() {
        findAll();
    }

    public void insert() {
        disciplinaOfertadaEJB.insert(disciplinaOfertada, idSemestre, idDisciplina, idProfessor);
        clean();
        findAll();
    }

    private void findAll() {
        disciplinaOfertadas = disciplinaOfertadaEJB.findAll();
    }

    public void update() {
        disciplinaOfertadaEJB.update(disciplinaOfertada, idSemestre, idDisciplina, idProfessor);
        clean();
        findAll();
    }

    public void delete() {
        disciplinaOfertadaEJB.delete(disciplinaOfertadaEJB.load(idPesquisa));
        clean();
        findAll();
    }

    public void pesquisar() {
        disciplinaOfertada = disciplinaOfertadaEJB.load(idPesquisa);
    }

    public void clean() {
        disciplinaOfertada = new DisciplinaOfertada();
    }

    public DisciplinaOfertada getDisciplinaOfertada() {
        if (disciplinaOfertada == null) {
            disciplinaOfertada = new DisciplinaOfertada();
        }
        return disciplinaOfertada;
    }

    public void setDisciplinaOfertada(DisciplinaOfertada disciplinaOfertada) {
        this.disciplinaOfertada = disciplinaOfertada;
    }

    public Integer getIdPesquisa() {
        return idPesquisa;
    }

    public void setIdPesquisa(Integer idPesquisa) {
        this.idPesquisa = idPesquisa;
    }

    public Integer getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Integer idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public Integer getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
    }

    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }
    
    public List<DisciplinaOfertada> getDisciplinaOfertadas() {
		return disciplinaOfertadas;
	}
}