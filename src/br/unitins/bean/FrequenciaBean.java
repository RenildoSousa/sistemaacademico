package br.unitins.bean;

import br.unitins.ejb.FrequenciaEJB;
import br.unitins.model.Frequencia;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class FrequenciaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private FrequenciaEJB frequenciaEJB;

    private Frequencia frequencia;

    private List<Frequencia> frequencias;

    private Integer idPesquisa;
    private Integer idMatricula;


    @PostConstruct
    public void init() {
        findAll();
    }

    public void insert() {
        frequenciaEJB.insert(frequencia, idMatricula);
        clean();
        findAll();
    }

    private void findAll() {
        frequencias = frequenciaEJB.findAll();
    }

    public void update() {
        frequenciaEJB.update(frequencia, idMatricula);
        clean();
        findAll();
    }

    public void delete() {
        frequenciaEJB.delete(frequenciaEJB.load(idPesquisa));
        clean();
        findAll();
    }

    public void pesquisar() {
        frequencia = frequenciaEJB.load(idPesquisa);
    }

    public void clean() {
        frequencia = new Frequencia();
    }

    public Frequencia getFrequencia() {
        if (frequencia == null) {
            frequencia = new Frequencia();
        }
        return frequencia;
    }

    public void setFrequencia(Frequencia frequencia) {
        this.frequencia = frequencia;
    }

    public Integer getIdPesquisa() {
        return idPesquisa;
    }

    public void setIdPesquisa(Integer idPesquisa) {
        this.idPesquisa = idPesquisa;
    }

    public Integer getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

	public List<Frequencia> getFrequencias() {
		return frequencias;
	}
}