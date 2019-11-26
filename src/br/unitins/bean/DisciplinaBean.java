package br.unitins.bean;

import br.unitins.ejb.DisciplinaEJB;
import br.unitins.model.Disciplina;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class DisciplinaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private DisciplinaEJB disciplinaEJB;

    private Disciplina disciplina;

    private List<Disciplina> disciplinas;

    private Integer idPesquisa;


    @PostConstruct
    public void init() {
        findAll();
    }

    public void insert() {
        disciplinaEJB.insert(disciplina);
        clean();
        findAll();
    }

    private void findAll() {
        disciplinas = disciplinaEJB.findAll();
    }

    public void update() {
        disciplinaEJB.update(disciplina);
        clean();
        findAll();
    }

    public void delete() {
        disciplinaEJB.delete(disciplinaEJB.load(idPesquisa));
        clean();
        findAll();
    }

    public void pesquisar() {
        disciplina = disciplinaEJB.load(idPesquisa);
    }

    public void clean() {
        disciplina = new Disciplina();
    }

    public Disciplina getDisciplina() {
        if (disciplina == null) {
            disciplina = new Disciplina();
        }
        return disciplina;
    }

    public void setDisciplina(Disciplina entity) {
        this.disciplina = entity;
    }

    public Integer getIdPesquisa() {
        return idPesquisa;
    }

    public void setIdPesquisa(Integer idPesquisa) {
        this.idPesquisa = idPesquisa;
    }

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}
}