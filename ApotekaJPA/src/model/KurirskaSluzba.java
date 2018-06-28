package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kurirska_sluzba database table.
 * 
 */
@Entity
@Table(name="kurirska_sluzba")
@NamedQuery(name="KurirskaSluzba.findAll", query="SELECT k FROM KurirskaSluzba k")
public class KurirskaSluzba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_kurirska_sluzba")
	private int idKurirskaSluzba;

	private String naziv;

	//bi-directional many-to-one association to Kupovina
	@OneToMany(mappedBy="kurirskaSluzba")
	private List<Kupovina> kupovinas;

	public KurirskaSluzba() {
	}

	public int getIdKurirskaSluzba() {
		return this.idKurirskaSluzba;
	}

	public void setIdKurirskaSluzba(int idKurirskaSluzba) {
		this.idKurirskaSluzba = idKurirskaSluzba;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Kupovina> getKupovinas() {
		return this.kupovinas;
	}

	public void setKupovinas(List<Kupovina> kupovinas) {
		this.kupovinas = kupovinas;
	}

	public Kupovina addKupovina(Kupovina kupovina) {
		getKupovinas().add(kupovina);
		kupovina.setKurirskaSluzba(this);

		return kupovina;
	}

	public Kupovina removeKupovina(Kupovina kupovina) {
		getKupovinas().remove(kupovina);
		kupovina.setKurirskaSluzba(null);

		return kupovina;
	}

}