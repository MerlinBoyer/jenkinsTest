package fr.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IEtudiantDao;
import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;

@Service("etudiantServiceBean")
@Transactional
public class EtudiantServiceImpl implements IEtudiantService {

	
	@Autowired(required=true)
	private IEtudiantDao etudiantDao;
	public void setFormDao(IEtudiantDao etudiantDao) {
		this.etudiantDao = etudiantDao;
	}
	
	
	@Override
	public List<Etudiant> getAll(Formateur f) {
		return etudiantDao.getAll(f);
	}

	@Override
	public int add(Etudiant e, Formateur f) {
		e.setFormateur( f );
		etudiantDao.add(e);
		return 1;
	}

	@Override
	public Etudiant getById(int id) {
		return etudiantDao.getById(id);
	}

	@Override
	public int update(Etudiant e, Formateur f) {
		e = etudiantDao.getById(e.getId());
		if(e == null || f.getId() != e.getFormateur().getId() ) {
			System.out.println("cannot update : etudiant " + e + ", formateur : " + f);
			return 0;
		}
		etudiantDao.update(e);
		return 1;
	}

	@Override
	public int delete(Etudiant e, Formateur f) {
		e = etudiantDao.getById(e.getId());
		if(e == null || f.getId() != e.getFormateur().getId() ) {
			System.out.println("cannot delete : etudiant " + e + ", formateur : " + f);
			return 0;
		}
		etudiantDao.delete(e);
		return 1;
	}

	
}
