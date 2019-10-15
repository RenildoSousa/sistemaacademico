package br.sistemaacademico.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.sistemaacademico.ejb.UnidadeOrganizacionalEJB;
import br.sistemaacademico.model.TipoDeOrganizacao;
import br.sistemaacademico.model.UnidadeOrganizacional;

@Named
@SessionScoped
public class UnidadeOrganizacionalBean implements Serializable{

	/**
	 Renildo Sousa
	 */
	private static final long serialVersionUID = -7155520158802395838L;
	
	@EJB
	private UnidadeOrganizacionalEJB unidadeOrganizacionalEJB;
	
	private TipoDeOrganizacao tipoDeOrganizacao;
	
	private UnidadeOrganizacional unidadeOrganizacional;
	
	private Integer idPesquisa;
	
	private List<UnidadeOrganizacional> listaUnidadeOrganizacional;


	@PostConstruct
	public void init() {
		listaUnidadeOrganizacional = unidadeOrganizacionalEJB.findAll();
	}
	public void inserir() {
		unidadeOrganizacionalEJB.insert(unidadeOrganizacional);
		listaUnidadeOrganizacional = unidadeOrganizacionalEJB.findAll();
	}
	
	public void alterar() {
		unidadeOrganizacionalEJB.update(unidadeOrganizacional);
		listaUnidadeOrganizacional = unidadeOrganizacionalEJB.findAll();
	}
	public void apagar() {
		unidadeOrganizacionalEJB.delete(unidadeOrganizacional);
		listaUnidadeOrganizacional = unidadeOrganizacionalEJB.findAll();
	}
	public String pequisar() {
		unidadeOrganizacionalEJB.load(idPesquisa);
		return null;
	}
	public void novo() {
		unidadeOrganizacional = null;
	}
	public UnidadeOrganizacional getUnidadeOrganizacional() {
		if (unidadeOrganizacional == null) {
			unidadeOrganizacional = new UnidadeOrganizacional();
		}
		return unidadeOrganizacional;
	}

	public void setUnidadeOrganizacional(UnidadeOrganizacional unidadeOrganizacional) {
		this.unidadeOrganizacional = unidadeOrganizacional;
	}

	public Integer getIdPesquisa() {
		return idPesquisa;
	}

	public void setIdPesquisa(Integer idPesquisa) {
		this.idPesquisa = idPesquisa;
	}

	public List<UnidadeOrganizacional> getListaUnidadeOrganizacional() {
		return listaUnidadeOrganizacional;
	}

	public void setListaUnidadeOrganizacional(List<UnidadeOrganizacional> listaUnidadeOrganizacional) {
		this.listaUnidadeOrganizacional = listaUnidadeOrganizacional;
	}
	public TipoDeOrganizacao getTipoDeOrganizacao() {
		return tipoDeOrganizacao;
	}
	public void setTipoDeOrganizacao(TipoDeOrganizacao tipoDeOrganizacao) {
		this.tipoDeOrganizacao = tipoDeOrganizacao;
	}
	public TipoDeOrganizacao[] getListaTipoDeOrganizacao() {
		return TipoDeOrganizacao.values();
	}
	
}
