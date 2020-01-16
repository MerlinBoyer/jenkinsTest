package fr.adaming.testEtudiantDao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IEtudiantDao;
import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/application-context.xml"})
public class TestEtudiantDao {
	
	@Autowired
	private IEtudiantDao etudiantDao;
	
	private Formateur testf;
	

	@Before
	public void setup() {
		this.testf = new Formateur(1, "a", "a");
	}
	
	
	@Test
	@Transactional(readOnly=true)
	public void oui() {
		this.etudiantDao
			.getAll(this.testf)
			.forEach( System.out::println );
		
		assertEquals(4, this.etudiantDao
			.getAll(this.testf).size());
		
	}
	
	@Test
	public void oui2() {
		this.etudiantDao.add(new Etudiant("nom", "prenom", new Date()));
	}
}
