package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the kupovina database table.
 * 
 */
@Entity
@NamedQuery(name="Kupovina.findAll", query="SELECT k FROM Kupovina k")
public class Kupovina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_kupovina")
	private int idKupovina;

	//bi-directional many-to-one association to KurirskaSluzba
	@ManyToOne
	@JoinColumn(name="kurirska_sluzba_id_kurirska_sluzba")
	private KurirskaSluzba kurirskaSluzba;

	//bi-directional many-to-one association to Osoba
	@ManyToOne
	private Osoba osoba;

	//bi-directional many-to-many association to Stavka
	@ManyToMany(mappedBy="kupovinas")
	private List<Stavka> stavkas;

	public Kupovina() {
	}

	public int getIdKupovina() {
		return this.idKupovina;
	}

	public void setIdKupovina(int idKupovina) {
		this.idKupovina = idKupovina;
	}

	public KurirskaSluzba getKurirskaSluzba() {
		return this.kurirskaSluzba;
	}

	public void setKurirskaSluzba(KurirskaSluzba kurirskaSluzba) {
		this.kurirskaSluzba = kurirskaSluzba;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

	public List<Stavka> getStavkas() {
		return this.stavkas;
	}

	public void setStavkas(List<Stavka> stavkas) {
		this.stavkas = stavkas;
	}

}