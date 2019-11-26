package br.unitins.bean;

import br.unitins.ejb.NotaEJB;
import br.unitins.model.Nota;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class NotaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private NotaEJB notaEJB;

    private Nota nota;

    private List<Nota> notas;

    private Integer idPesquisa;
    private Integer idMatricula;


    @PostConstruct
    public void init() {
        findAll();
    }

    public void insert() {
        notaEJB.insert(nota, idMatricula);
        clean();
        findAll();
    }

    private void findAll() {
        notas = notaEJB.findAll();
    }

    public void update() {
        notaEJB.update(nota, idMatricula);
        clean();
        findAll();
    }

    public void delete() {
        notaEJB.delete(notaEJB.load(idPesquisa));
        clean();
        findAll();
    }

    public void pesquisar() {
        nota = notaEJB.load(idPesquisa);
    }

    public void clean() {
        nota = new Nota();
    }

    public Nota getNota() {
        if (nota == null) {
            nota = new Nota();
        }
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
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

	public List<Nota> getNotas() {
		return notas;
	}
}
