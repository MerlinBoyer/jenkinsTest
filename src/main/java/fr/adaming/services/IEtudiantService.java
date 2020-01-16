package fr.adaming.services;

import java.util.List;

import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;

public interface IEtudiantService {

	public List<Etudiant> getAll(Formateur f);
	
	public int add(Etudiant e, Formateur f);
	
	public Etudiant getById(int id);
	
	public int update(Etudiant e, Formateur f);
	
	public int delete(Etudiant e, Formateur f);
	
}
