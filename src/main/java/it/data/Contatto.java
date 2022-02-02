package it.data;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name="Contatto")
@NamedQuery(name="contatto.GetByCognome", query="SELECT c FROM Contatto c WHERE c.cognome= :cognome")
//@NamedQuery(name="numTelefono.GetByNumero", query="SELECT c FROM Numtelefono c WHERE c.numero= :numero")
@NamedQuery(name="contatto.GetAll", query="SELECT c FROM Contatto c")
public class Contatto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String cognome;
	private String nome;
	private String email;
	private ArrayList<NumTelefono> numTelefoni;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="cognome")
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	@Column(name="nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@OneToMany(mappedBy = "contatto", cascade = CascadeType.ALL )
	@JoinColumn(name="numerotelefono")
	
	public ArrayList<NumTelefono> getNumTelefoni() {
		return numTelefoni;
	}
	public void setNumTelefoni(ArrayList<NumTelefono> numTelefoni) {
		this.numTelefoni = numTelefoni;
	}

	
}
