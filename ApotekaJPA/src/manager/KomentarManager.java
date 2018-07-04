package manager;

import java.util.List;

import javax.persistence.EntityManager;

import model.Komentar;
import model.Lek;
import model.Osoba;

public class KomentarManager {

	public static List<Komentar> getKomentari(String odabraniLekID) {
		// TODO Auto-generated method stub
		EntityManager em = JPAUtil.getEntityManager();
		Lek lek = em.find(Lek.class, Integer.valueOf(odabraniLekID));
		return lek == null ? null
				: em.createQuery("SELECT k FROM Komentar k where k.lek = :lek").setParameter("lek", lek)
						.getResultList();
	}

	public static void komentarisi(String odabraniLekId, Osoba osoba, String tekstKomentara) {
		// TODO Auto-generated method stub
		try {
			EntityManager em = JPAUtil.getEntityManager();
			em.getTransaction().begin();
			Lek lek = em.find(Lek.class, Integer.valueOf(odabraniLekId));
			Osoba o = em.find(Osoba.class, osoba.getIdOsoba());
			Komentar kom = new Komentar();
			kom.setOsoba(o);
			kom.setKomentar(tekstKomentara);
			kom.setLek(lek);
			em.persist(kom);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
