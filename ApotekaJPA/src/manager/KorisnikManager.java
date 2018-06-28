package manager;


import javax.persistence.EntityManager;

import model.Korisnik;

public class KorisnikManager {
	public static Korisnik login(String username,String password) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			Korisnik korisnik=(Korisnik) em.createQuery("SELECT k FROM Korisnik k where k.username=:username and k.pass=:pass").setParameter("username",username).setParameter("pass", password).getSingleResult();
			return korisnik;
		}catch(Exception e) {
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

