package fr.adaming.dao;

import java.util.List;

import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;

public interface IEtudiantDao {

	public List<Etudiant> getAll(Formateur f);
	
	public Etudiant add(Etudiant e);
	
	public Etudiant getById(int id);
	
	public void update(Etudiant e);
	
	public void delete(Etudiant e);
	
}
