package manager;

import java.util.ArrayList;

import javax.persistence.EntityManager;

import model.Kupovina;
import model.KurirskaSluzba;
import model.Osoba;

public class KupovinaManager {
	public static boolean novaKupovina(KurirskaSluzba kurirskaSluzba,Osoba osoba) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			Kupovina kupovina = new Kupovina();
			kupovina.setKurirskaSluzba(kurirskaSluzba);
			kupovina.setStavkas(osoba.getStavkas());
			em.getTransaction().begin();
			osoba.setStavkas(new ArrayList<>());
			em.merge(osoba);
			kupovina.setOsoba(osoba);
			em.persist(kupovina);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){
			em.close();
			e.printStackTrace();
			return false;
		}
	}
}
