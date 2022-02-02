package it.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import it.data.Contatto;
import it.data.NumTelefono;



//aggiungo un commento di prova

@Stateless
@LocalBean
public class RubricaEjb implements RubricaEjbLocal {
	@PersistenceContext(unitName="Rubrica")
	EntityManager em;

    public RubricaEjb() {
    	  
    }
    
    @SuppressWarnings("unchecked")
    public List<NumTelefono> getAllNumeri() {
   	 Query q=em.createNamedQuery("numero.GetAll");
   	  return q.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public List<Contatto> getAllContatti() {
   	 Query q=em.createNamedQuery("contatto.GetAll");
   	  return q.getResultList();
    }
    
    public void inserisci(Contatto c) {
    	em.persist(c);
    	em.flush();
    }
    
    @SuppressWarnings("unchecked")
	public List<Contatto> getContattoByCognome(String cognome) {
   	 Query q=em.createNamedQuery("contatto.GetByCognome");
   	 q.setParameter("cognome", cognome);
  	      return  q.getResultList();  	 
    }
    
    public Contatto getContattoByNumero(String numerotelefono) {
   	 Query q=em.createNamedQuery("contatto.GetByNumero");
   	 q.setParameter("numerotelefono", numerotelefono);
  	      return (Contatto) q.getResultList();  	 
    }
    
    public void aggiornaContatto(Contatto c) {
    	
	    em.merge(c);
	    em.flush();
 }
    public void elimina(Contatto c) {
    	
    	em.remove(em.find(Contatto.class, c.getId()));
    }
}
