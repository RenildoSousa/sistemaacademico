package br.unitins.bean;

import br.unitins.ejb.AlunoEJB;
import br.unitins.model.Aluno;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class AlunoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private AlunoEJB alunoEJB;

    private Aluno aluno;

    private List<Aluno> alunos;

    private Integer idPesquisa;


    @PostConstruct
    public void init() {
        findAll();
    }

    public void insert() {
        alunoEJB.insert(aluno);
        clean();
        findAll();
    }

    private void findAll() {
        alunos = alunoEJB.findAll();
    }

    public void update() {
        alunoEJB.update(aluno);
        clean();
        findAll();
    }

    public void delete() {
        alunoEJB.delete(alunoEJB.load(idPesquisa));
        clean();
        findAll();
    }

    public void pesquisar() {
        aluno = alunoEJB.load(idPesquisa);
    }

    public void clean() {
        aluno = new Aluno();
    }

    public Aluno getAluno() {
        if (aluno == null) {
            aluno = new Aluno();
        }
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Integer getIdPesquisa() {
        return idPesquisa;
    }

    public void setIdPesquisa(Integer idPesquisa) {
        this.idPesquisa = idPesquisa;
    }

	public List<Aluno> getAlunos() {
		return alunos;
	}

}