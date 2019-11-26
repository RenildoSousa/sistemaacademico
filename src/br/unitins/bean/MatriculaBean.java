package br.unitins.bean;

import br.unitins.ejb.MatriculaEJB;
import br.unitins.model.Matricula;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class MatriculaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private MatriculaEJB matriculaEJB;

    private Matricula matricula;

    private List<Matricula> matriculas;

    private Integer idPesquisa;
    private Integer idAluno;
    private Integer idDisciplinaOF;


    @PostConstruct
    public void init() {
        findAll();
    }

    public void insert() {
        matriculaEJB.insert(matricula, idAluno, idDisciplinaOF);
        clean();
        findAll();
    }

    private void findAll() {
        matriculas = matriculaEJB.findAll();
    }

    public void update() {
        matriculaEJB.update(matricula, idAluno, idDisciplinaOF);
        clean();
        findAll();
    }

    public void delete() {
        matriculaEJB.delete(matriculaEJB.load(idPesquisa));
        clean();
        findAll();
    }

    public void pesquisar() {
        matricula = matriculaEJB.load(idPesquisa);
    }

    public void clean() {
        matricula = new Matricula();
    }

    public Matricula getMatricula() {
        if (matricula == null) {
            matricula = new Matricula();
        }
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public Integer getIdPesquisa() {
        return idPesquisa;
    }

    public void setIdPesquisa(Integer idPesquisa) {
        this.idPesquisa = idPesquisa;
    }

    public Integer getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Integer idAluno) {
        this.idAluno = idAluno;
    }

    public Integer getIdDisciplinaOF() {
        return idDisciplinaOF;
    }

    public void setIdDisciplinaOF(Integer idDisciplinaOF) {
        this.idDisciplinaOF = idDisciplinaOF;
    }

	public List<Matricula> getMatriculas() {
		return matriculas;
	}
}