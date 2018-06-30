package manager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import model.Korisnik;
import model.Lek;
import model.Osoba;
import model.Stavka;

public class StavkaManager {
	public static List<Stavka> listaStavki(Osoba o){
		try {
			EntityManager em=JPAUtil.getEntityManager();
			return em.createQuery("Select o.stavkas from Osoba o where o.idOsoba=:idOsobe").setParameter("idOsobe", o.getIdOsoba()).getResultList();
		}catch(Exception e) {

			e.printStackTrace();
			return null;
		}
	}
	
	
	public static boolean dodajStavkuKorisniku(Osoba korisnik, Lek lek) {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		try {
			List<Stavka> listaStavki = listaStavki(korisnik);
			if(listaStavki!=null) {
				for (Stavka stavka : listaStavki) {
					if(lek.getNaziv().equals(stavka.getLek().getNaziv())) {
						stavka.setKolicina(stavka.getKolicina()+1);
						em.merge(stavka);
						em.getTransaction().commit();
						em.close();
						return true;
					}
				}
			}else{
				listaStavki = new ArrayList<>();
			}
			Stavka stavka=new Stavka();
			stavka.setLek(lek);
			stavka.setKolicina(1);
			em.persist(stavka);
			em.flush();
			listaStavki.add(stavka);
			korisnik.setStavkas(listaStavki);
			em.merge(korisnik);
			em.getTransaction().commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			em.close();
			return false;
		}
	}
	
	public static void main(String[] args) {
		Osoba osoba=OsobaManager.getOsobaById("3");
		Lek lek =LekManager.findLekById("6");
		System.out.println(osoba.getIme());
		List<Stavka> listaStavki=listaStavki(osoba);
		dodajStavkuKorisniku(osoba,lek);
	}
}
