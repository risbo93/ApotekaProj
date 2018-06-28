package manager;

import java.util.List;

import javax.persistence.EntityManager;

import model.Korisnik;
import model.Lek;

public class LekManager {
	public static boolean dodajLek(String naziv, String cenaStr) {
		try {
			Integer cena=Integer.parseInt(cenaStr);
			EntityManager em=JPAUtil.getEntityManager();
			Lek lek=new Lek();
			lek.setCena(cena);
			lek.setNaziv(naziv);
			lek.setObrisano((byte) 0);
			em.getTransaction().begin();
			em.persist(lek);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public static List<Lek> listaLekova(){
		EntityManager em=JPAUtil.getEntityManager();
		return em.createQuery("SELECT l FROM Lek l where l.obrisano=0").getResultList();
	}
	
	public static Lek findLekById(String idStr) {
		try {

			EntityManager em=JPAUtil.getEntityManager();
			Integer id=Integer.parseInt(idStr);
			return (Lek) em.createQuery("SELECT l FROM Lek l where l.idLek = :id").setParameter("id", id).getSingleResult();
		}catch(Exception e) {
			return null;
		}
	}
	
	public static boolean obrisiLek(Lek lek) {
		try {
			lek.setObrisano((byte) 1);
			EntityManager em=JPAUtil.getEntityManager();
			em.getTransaction().begin();
			em.merge(lek);
			em.getTransaction().commit();
			em.close();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Lek lek=findLekById("5");
		obrisiLek(lek);
	}

}
