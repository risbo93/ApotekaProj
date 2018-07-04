package manager;

import java.util.List;

import javax.persistence.EntityManager;

import org.jasypt.util.password.StrongPasswordEncryptor;

import model.Korisnik;
import model.Osoba;
import model.Stavka;

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
	
	public static Osoba getOsobaById(String idStr) {
		EntityManager em=JPAUtil.getEntityManager();
		try {
			Integer id=Integer.parseInt(idStr);
			return (Osoba) em.createQuery("SELECT o FROM Osoba o where o.idOsoba=:id").setParameter("id", id).getSingleResult();
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
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			String encryptedPassword = passwordEncryptor.encryptPassword(password);
			korisnik.setPass(encryptedPassword);
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
	
	public static int cenaKupovine(Osoba osoba) {
		List<Stavka> listaStavki = osoba.getStavkas();
		if (listaStavki.isEmpty())
			return 0;
		int cena=0;
		for (Stavka stavka : listaStavki) {
			cena+=stavka.getLek().getCena()*stavka.getKolicina();
		}
		return cena;
	}
	
	public static void main(String []args) {
		dodajOsobu("Bojan", "Ivanovic", "24", "bojan", "bojan123","bojan123", "Beograd", "Balkanska 4", "0611132258");
	}
}
