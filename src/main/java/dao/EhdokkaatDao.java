package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import persist.Ehdokkaat;
import persist.Kysymykset;

public class EhdokkaatDao {

	public static char event;
	public static int ehdokas = -1;
	public static int currentID = -1;
	public static boolean confirmAdd = false;
	public static boolean confirmEdit = false;
	public static boolean confirmAddQuestion = false;
	public static boolean confirmDelete = false;
	private static EntityManagerFactory emf;

	public EhdokkaatDao() {

	}

	private static EntityManager GetEntityManager() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("vaalikones");
		}
		return emf.createEntityManager();
	}

	public void DeleteEhdokas() {
		EntityManager em = GetEntityManager();

		Ehdokkaat obj = em.find(Ehdokkaat.class, currentID);

		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
		em.close();
	}

	public void UpdateEhdokas(String sukunimi, String etunimi, String puolue, String kotipaikkakunta, int ika,
			String miksieduskuntaan, String mitaedistaa, String ammatti, int ehdokasnumero) {
		EntityManager em = GetEntityManager();

		Ehdokkaat obj = em.find(Ehdokkaat.class, currentID);

		obj.setSukunimi(sukunimi);
		obj.setEtunimi(etunimi);
		obj.setPuolue(puolue);
		obj.setKotipaikkakunta(kotipaikkakunta);
		obj.setIka(ika);
		obj.setMiksiEduskuntaan(miksieduskuntaan);
		obj.setMitaAsioitaHaluatEdistaa(mitaedistaa);
		obj.setAmmatti(ammatti);

		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
	}

	public List<Ehdokkaat> GetEhdokkaat() {
		EntityManager em = GetEntityManager();
		List<Ehdokkaat> list = em.createQuery("select a from Ehdokkaat a").getResultList();
		em.close();

		System.out.println(list);

		return list;
	}

	public void AddEhdokas(String sukunimi, String etunimi, String puolue, String kotipaikkakunta, int ika,
			String miksieduskuntaan, String mitaedistaa, String ammatti, int ehdokasnumero) {
		EntityManager em = GetEntityManager();

		// Viimeisen ID:n haku
		List<Ehdokkaat> list = GetEhdokkaat();
		Ehdokkaat last = list.get(list.size() - 1);

		// Uuden ehdokkaan luonti
		Ehdokkaat obj = new Ehdokkaat();
		obj.setEhdokasId(last.getEhdokasId() + 1);
		obj.setSukunimi(sukunimi);
		obj.setEtunimi(etunimi);
		obj.setPuolue(puolue);
		obj.setKotipaikkakunta(kotipaikkakunta);
		obj.setIka(ika);
		obj.setMiksiEduskuntaan(miksieduskuntaan);
		obj.setMitaAsioitaHaluatEdistaa(mitaedistaa);
		obj.setAmmatti(ammatti);
		obj.setEhdokasnumero(ehdokasnumero);

		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
		em.close();
	}

	public Ehdokkaat findEhdokas(int num) {
		EntityManager em = GetEntityManager();
		Ehdokkaat ehdokas;

		// Ehdokkaat ehdokas = em.find(Ehdokkaat.class, num);
		List<Ehdokkaat> list = em.createNamedQuery("Ehdokkaat.findByEhdokasnumero").setParameter("ehdokasnumero", num)
				.getResultList();

		if (num < 0) {
			return null;
		} else {
			ehdokas = list.get(0);
		}

		return ehdokas;
	}

	public static List<Ehdokkaat> getEhdokkaat() {
		
			EntityManager em = GetEntityManager();
			List<Ehdokkaat> list = em.createQuery("select a from Ehdokkaat a").getResultList();
			em.close();

			return list;
	}
}
