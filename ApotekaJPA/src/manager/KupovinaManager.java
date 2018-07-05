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
			if(stavkas.isEmpty() || stavkas==null) {
				System.out.println("korpa prazna");
				return false;
			}
			else {
				System.out.println("korpa nije prazna");
			}
			kupovina.setOsoba(osoba);
			em.persist(kupovina);
			em.flush();
			List<Kupovina> kupovinas = new ArrayList<>();
			kupovinas.add(kupovina);
			for(Stavka s:stavkas){
				System.out.println("stavka------>"+s.getLek().getNaziv());
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
	
	public static List<Kupovina> listaKupovina(){
		EntityManager em = JPAUtil.getEntityManager();
		return em.createQuery("SELECT k FROM Kupovina k").getResultList();
	}
	
	public static void main(String[] args){
		Osoba o = OsobaManager.getOsobaById("3");
		KurirskaSluzba k = KurirskaSluzbaManager.findKurirskaSluzbaById("3");
		novaKupovina(k,o);
		}
}
