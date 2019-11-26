package br.unitins.bean;

import br.unitins.ejb.SemestreEJB;
import br.unitins.model.Semestre;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class SemestreBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private SemestreEJB semestreEJB;

    private Semestre semestre;

    private List<Semestre> semestres;

    private Integer idPesquisa;


    @PostConstruct
    public void init() {
        findAll();
    }

    public void insert() {
        semestreEJB.insert(semestre);
        clean();
        findAll();
    }

    private void findAll() {
        semestres = semestreEJB.findAll();
    }

    public void update() {
        semestreEJB.update(semestre);
        clean();
        findAll();
    }

    public void delete() {
        semestreEJB.delete(semestreEJB.load(idPesquisa));
        clean();
        findAll();
    }

    public void pesquisar() {
        semestre = semestreEJB.load(idPesquisa);
    }

    public void clean() {
        semestre = new Semestre();
    }

    public Semestre getSemestre() {
        if (semestre == null) {
            semestre = new Semestre();
        }
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Integer getIdPesquisa() {
        return idPesquisa;
    }

    public void setIdPesquisa(Integer idPesquisa) {
        this.idPesquisa = idPesquisa;
    }

	public List<Semestre> getSemestres() {
		return semestres;
	}

}