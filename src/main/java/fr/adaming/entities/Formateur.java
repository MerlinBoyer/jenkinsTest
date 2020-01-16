package fr.adaming.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="formateurs")
public class Formateur implements Serializable{
	
	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_f")
	private int id;
	
	private String mail;
	
	private String mdp;
	
	@OneToMany(mappedBy="formateur", cascade=CascadeType.ALL)
	private List<Etudiant> listEtudiants;
	
	
	

	public Formateur(int id, String mail, String mdp) {
		super();
		this.id = id;
		this.mail = mail;
		this.mdp = mdp;
	}

	public Formateur(String mail, String mdp) {
		super();
		this.mail = mail;
		this.mdp = mdp;
	}

	public Formateur() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public List<Etudiant> getListEtudiants() {
		return listEtudiants;
	}

	public void setListEtudiants(List<Etudiant> listEtudiants) {
		this.listEtudiants = listEtudiants;
	}
	
	public void addEtudiants(Etudiant e) {
		this.listEtudiants.add(e);
	}

	@Override
	public String toString() {
		return "Formateur [id=" + id + ", mail=" + mail + ", mdp=" + mdp + ", listEtudiants=" + listEtudiants + "]";
	}

	
	
}
