package br.unitins.bean;

import br.unitins.ejb.CursoEJB;
import br.unitins.model.Curso;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CursoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private CursoEJB cursoEJB;

    private Curso curso;

    private List<Curso> cursos;

    private Integer idPesquisa;
    private Integer idInstituicao;


    @PostConstruct
    public void init() {
        findAll();
    }

    public void insert() {
        cursoEJB.insert(curso,idInstituicao);
        clean();
        findAll();
    }

    private void findAll() {
        cursos = cursoEJB.findAll();
    }

    public void update() {
        cursoEJB.update(curso,idInstituicao);
        clean();
        findAll();
    }

    public void delete() {
        cursoEJB.delete(cursoEJB.load(idPesquisa));
        clean();
        findAll();
    }

    public void pesquisar() {
        curso = cursoEJB.load(idPesquisa);
    }

    public void clean() {
        curso = new Curso();
    }

    public Curso getCurso() {
        if (curso == null) {
            curso = new Curso();
        }
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Integer getIdPesquisa() {
        return idPesquisa;
    }

    public void setIdPesquisa(Integer idPesquisa) {
        this.idPesquisa = idPesquisa;
    }

    public Integer getIdInstituicao() {
        return idInstituicao;
    }

    public void setIdInstituicao(Integer idInstituicao) {
        this.idInstituicao = idInstituicao;
    }

	public List<Curso> getCursos() {
		return cursos;
	}
}