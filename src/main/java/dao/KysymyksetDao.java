package dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import persist.Kysymykset;

public class KysymyksetDao {
    private static EntityManagerFactory emf;
    private static EntityManager getEntityManager() {
        if (emf==null) {
            emf=Persistence.createEntityManagerFactory("vaalikones");
        }
        return emf.createEntityManager();
    }
    
    public static List<Kysymykset> getKysymykset(){
        EntityManager em=getEntityManager();
        List<Kysymykset> list=em.createQuery("select a from Kysymykset a").getResultList();
        em.close();
        return list;
    }
}
