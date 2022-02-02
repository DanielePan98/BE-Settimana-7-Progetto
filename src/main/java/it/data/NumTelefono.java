package it.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="NumTelefono")
@NamedQuery(name="numero.GetAll", query="SELECT n FROM NumTelefono n")
public class NumTelefono implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String numero;
	private Contatto contatto;
	
	@Id																																																											
	@Column(name="numerotelefono")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	@ManyToOne
	@JoinColumn(name="id")
	public Contatto getContatto() {
		return contatto;
	}
	public void setContatto(Contatto contatto) {
		this.contatto = contatto;
	}
	

}
