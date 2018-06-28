package manager;

import java.util.List;

import javax.persistence.EntityManager;

import model.Korisnik;
import model.Osoba;

public class OsobaManager {
	public static final String ULOGAKORISNIK="korisnik";
	public static Osoba pronadjiOsobu(Korisnik korisnik) {
		EntityManager em=JPAUtil.getEntityManager();
		try {
			Osoba osoba=(Osoba) em.createQuery("Select o from Osoba o where o.korisnik=:korisnik").setParameter("korisnik", korisnik).getSingleResult();
			return osoba;
		}catch(Exception e) {
			return null;
		}
	}
	
	public static boolean dodajOsobu(String ime, String prezime, String godineStr, String username, String password, String passwordConfirm,String grad,String ulica,String telefon) {
		if(!password.equals(passwordConfirm)) {
			return false;
		}
		EntityManager em=JPAUtil.getEntityManager();
		try {
			Integer godine=Integer.parseInt(godineStr);
			Korisnik korisnik=new Korisnik();
			korisnik.setUsername(username);
			korisnik.setPass(password);
			if(KorisnikManager.proveraPostojanja(username)) {
				return false;
			}
			em.getTransaction().begin();
			em.persist(korisnik);
			em.flush();
			Osoba osoba=new Osoba();
			osoba.setKorisnik(korisnik);
			osoba.setBrTelefona(telefon);
			osoba.setGrad(grad);
			osoba.setGodine(godine);
			osoba.setIme(ime);
			osoba.setPrezime(prezime);
			osoba.setUlica(ulica);
			osoba.setUloga(ULOGAKORISNIK);
			em.persist(osoba);
			em.getTransaction().commit();
			
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally {
			em.close();
		}
	}
	
	public static void listKor() {
		EntityManager em=JPAUtil.getEntityManager();
		List<Korisnik> korisnici = em.createQuery("from Korisnik k").getResultList();
		for (Korisnik korisnik : korisnici) {
			System.out.println(korisnik.toString());
		}
	}
	
	public static boolean stop() {
		EntityManager em=JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.close();
		return true;
	}
	
	public static void main(String []args) {
		dodajOsobu("Bojan", "Ivanovic", "24", "bojan", "bojan123","bojan123", "Beograd", "Balkanska 4", "0611132258");
	}
}
