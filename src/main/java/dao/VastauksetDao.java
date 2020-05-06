package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import persist.Vastaukset;

public class VastauksetDao {
	
	private static EntityManagerFactory emf;
	public static int vastaustenMaara;
	
	private static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("vaalikones");
		}
		return emf.createEntityManager();
	}
	
	public static List<Vastaukset> getVastaukset(int id) {
		EntityManager em = getEntityManager();
		List<Vastaukset> list = em.createNamedQuery("Vastaukset.findByEhdokasId").setParameter("ehdokasId", id).getResultList();
		em.close();

		return list;
	}

}
