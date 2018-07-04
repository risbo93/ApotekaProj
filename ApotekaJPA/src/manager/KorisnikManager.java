package manager;


import javax.persistence.EntityManager;

import org.jasypt.util.password.StrongPasswordEncryptor;

import model.Korisnik;

public class KorisnikManager {
	public static Korisnik login(String username,String password) {
		EntityManager em = JPAUtil.getEntityManager();
		String encryptedPassword = "";
		Korisnik korisnik = null;
		try {
			korisnik=(Korisnik) em.createQuery("SELECT k FROM Korisnik k where k.username=:username").setParameter("username",username).getSingleResult();
			encryptedPassword = korisnik!=null?korisnik.getPass() : "";
			StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
			if (passwordEncryptor.checkPassword(password, encryptedPassword)) {
				return korisnik;
			}
			return null;
		}catch(Exception e) {
			if(encryptedPassword.equals(password)) {
				return korisnik;
			}
			return null;
		}
	}
	
	public static boolean proveraPostojanja(String username) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			Korisnik korisnik=(Korisnik) em.createQuery("SELECT k FROM Korisnik k where k.username=:username").setParameter("username",username).getSingleResult();
			if(korisnik!=null)
				return true;
			return false;
		}catch(Exception e) {
			return false;
		}
		
	}
	
}

