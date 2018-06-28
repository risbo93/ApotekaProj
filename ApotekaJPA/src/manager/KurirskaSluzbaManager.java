package manager;

import java.util.List;

import javax.persistence.EntityManager;

import model.KurirskaSluzba;

public class KurirskaSluzbaManager {
	public static List<KurirskaSluzba> listaKurirskihSluzbi(){
		EntityManager em=JPAUtil.getEntityManager();
		return em.createQuery("SELECT k FROM KurirskaSluzba k").getResultList();
	}
	
	public static KurirskaSluzba findKurirskaSluzbaById(String idStr) {
		EntityManager em=JPAUtil.getEntityManager();
		Integer id=Integer.parseInt(idStr);
		return (KurirskaSluzba) em.createQuery("SELECT k FROM KurirskaSluzba k where k.idKurirskaSluzba=:id").setParameter("id", id).getSingleResult();
	}
}
