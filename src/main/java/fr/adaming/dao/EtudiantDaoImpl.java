package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;

@Repository("etudiantDaoBean")
public class EtudiantDaoImpl implements IEtudiantDao{

	
	@Autowired(required=true)    //require one setter
	private SessionFactory sf;
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	
	@Override
	public List<Etudiant> getAll(Formateur f) {
		// first get current session
		Session sess = sf.getCurrentSession(); 
		
		// need an id to get formateur from session....
		//   -> HPQ request
		String req = "FROM Etudiant e WHERE e.formateur.id=:pId";
		
		Query q = sess.createQuery( req );
		q.setParameter("pId", f.getId());
		
		return q.list();
	}
	
	@Override
	public Etudiant add(Etudiant e) {
		
		Session sess = sf.getCurrentSession();
		
		sess.save(e);
		
		return e;
	}

	@Override
	public Etudiant getById(int id) {
		
		Session sess = sf.getCurrentSession();
		
		return (Etudiant) sess.get(Etudiant.class, id);
		
	}
	
	@Override
	public void update(Etudiant e) {
		Session sess = sf.getCurrentSession();
		
		sess.saveOrUpdate( e );
		
		return;
		
	}
	
	@Override
	public void delete(Etudiant e) {
		Session sess = sf.getCurrentSession();
		
		sess.delete( e );
		
		return;
	}

	
}
