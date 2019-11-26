package br.unitins.bean;

import br.unitins.ejb.InstituicaoEJB;
import br.unitins.model.Instituicao;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class InstituicaoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private InstituicaoEJB instituicaoEJB;

    private Instituicao instituicao;

    private List<Instituicao> instituicaos;

    private Integer idPesquisa;


    @PostConstruct
    public void init() {
        findAll();
    }

    public void insert() {
        instituicaoEJB.insert(instituicao);
        clean();
        findAll();
    }

    private void findAll() {
        instituicaos = instituicaoEJB.findAll();
    }

    public void update() {
        instituicaoEJB.update(instituicao);
        clean();
        findAll();
    }

    public void delete() {
        instituicaoEJB.delete(instituicaoEJB.load(idPesquisa));
        clean();
        findAll();
    }

    public void pesquisar() {
        instituicao = instituicaoEJB.load(idPesquisa);
    }

    public void clean() {
        instituicao = new Instituicao();
    }

    public Instituicao getInstituicao() {
        if (instituicao == null) {
            instituicao = new Instituicao();
        }
        return instituicao;
    }

    public void setInstituicao(Instituicao entity) {
        this.instituicao = entity;
    }

    public Integer getIdPesquisa() {
        return idPesquisa;
    }

    public void setIdPesquisa(Integer idPesquisa) {
        this.idPesquisa = idPesquisa;
    }

	public List<Instituicao> getInstituicaos() {
		return instituicaos;
	}
}
