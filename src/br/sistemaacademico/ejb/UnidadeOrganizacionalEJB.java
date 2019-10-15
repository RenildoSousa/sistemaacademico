package br.sistemaacademico.ejb;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.sistemaacademico.model.UnidadeOrganizacional;

@Stateful
public class UnidadeOrganizacionalEJB {
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(UnidadeOrganizacional unidadeOrganizacional) {
		em.persist(unidadeOrganizacional);
	}
	
	public void update(UnidadeOrganizacional unidadeOrganizacional) {
		em.merge(unidadeOrganizacional);
	}
	
	public void delete(UnidadeOrganizacional unidadeOrganizacional) {
		unidadeOrganizacional = load(unidadeOrganizacional.getId());
		em.remove(unidadeOrganizacional);
		
	}
	
	public UnidadeOrganizacional load(Integer id) {
		return em.find(UnidadeOrganizacional.class, id);
	}
	
	public List<UnidadeOrganizacional> findAll() {
		return em.createQuery("select u from UnidadeOrganizacional u", UnidadeOrganizacional.class).getResultList();
	}
	
	

}
