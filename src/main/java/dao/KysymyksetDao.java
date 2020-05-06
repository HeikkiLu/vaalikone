package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import persist.Kysymykset;

public class KysymyksetDao {

	private static EntityManagerFactory emf;
	public static int kysymystenMaara;

	private static EntityManager getEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("vaalikones");
		}
		return emf.createEntityManager();
	}

	public static List<Kysymykset> getKysymykset() {
		EntityManager em = getEntityManager();
		List<Kysymykset> list = em.createQuery("select a from Kysymykset a").getResultList();
		em.close();

		// Tallennetaan kysymysten määrä jotta tätä voidaan käyttää vaalikone.javassa
		kysymystenMaara = list.size();

		return list;
	}

	public static void addKysymys(Kysymykset obj) {
		EntityManager em = getEntityManager();

		// Viimeisen ID:n haku
		List<Kysymykset> list = getKysymykset();
		Kysymykset last = list.get(list.size() - 1);
		obj.setKysymysId(last.getKysymysId() + 1);

		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
	}
}
