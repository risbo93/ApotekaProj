package manager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.Kupovina;
import model.KurirskaSluzba;
import model.Osoba;
import model.Stavka;

public class KupovinaManager {
	public static boolean novaKupovina(KurirskaSluzba kurirskaSluzba,Osoba osoba) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Kupovina kupovina = new Kupovina();
			kupovina.setKurirskaSluzba(kurirskaSluzba);
			List<Stavka> stavkas = osoba.getStavkas();
//			kupovina.setStavkas(stavkas);
			kupovina.setOsoba(osoba);
			em.persist(kupovina);
			em.flush();
			List<Kupovina> kupovinas = new ArrayList<>();
			kupovinas.add(kupovina);
			for(Stavka s:stavkas){
				Stavka st = em.find(Stavka.class, s.getIdStavka());
				st.setKupovinas(kupovinas);
				em.persist(st);
			}
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){
			em.close();
			e.printStackTrace();
			return false;
		}
	}
	
	public static boolean ocistiKorpu(Osoba o){
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			Osoba osoba = em.find(Osoba.class, o.getIdOsoba());
			osoba.setStavkas(new ArrayList<>());
			em.persist(osoba);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e){
			em.close();
			e.printStackTrace();
			return false;
		}
	}
	
	public static void main(String[] args){
		Osoba o = OsobaManager.getOsobaById("1");
		KurirskaSluzba k = KurirskaSluzbaManager.findKurirskaSluzbaById("1");
		novaKupovina(k,o);
		ocistiKorpu(o);
	}
}
