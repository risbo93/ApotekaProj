package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the komentar database table.
 * 
 */
@Entity
@NamedQuery(name="Komentar.findAll", query="SELECT k FROM Komentar k")
public class Komentar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_komentar")
	private int idKomentar;

	private String komentar;

	//bi-directional many-to-one association to Lek
	@ManyToOne
	private Lek lek;

	//bi-directional many-to-one association to Osoba
	@ManyToOne
	private Osoba osoba;

	public Komentar() {
	}

	public int getIdKomentar() {
		return this.idKomentar;
	}

	public void setIdKomentar(int idKomentar) {
		this.idKomentar = idKomentar;
	}

	public String getKomentar() {
		return this.komentar;
	}

	public void setKomentar(String komentar) {
		this.komentar = komentar;
	}

	public Lek getLek() {
		return this.lek;
	}

	public void setLek(Lek lek) {
		this.lek = lek;
	}

	public Osoba getOsoba() {
		return this.osoba;
	}

	public void setOsoba(Osoba osoba) {
		this.osoba = osoba;
	}

}