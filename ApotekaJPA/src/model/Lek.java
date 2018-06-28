package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the lek database table.
 * 
 */
@Entity
@NamedQuery(name="Lek.findAll", query="SELECT l FROM Lek l")
public class Lek implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_lek")
	private int idLek;

	private int cena;

	private String naziv;

	private byte obrisano;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="lek")
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Stavka
	@OneToMany(mappedBy="lek")
	private List<Stavka> stavkas;

	public Lek() {
	}

	public int getIdLek() {
		return this.idLek;
	}

	public void setIdLek(int idLek) {
		this.idLek = idLek;
	}

	public int getCena() {
		return this.cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public String getNaziv() {
		return this.naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public byte getObrisano() {
		return this.obrisano;
	}

	public void setObrisano(byte obrisano) {
		this.obrisano = obrisano;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setLek(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setLek(null);

		return komentar;
	}

	public List<Stavka> getStavkas() {
		return this.stavkas;
	}

	public void setStavkas(List<Stavka> stavkas) {
		this.stavkas = stavkas;
	}

	public Stavka addStavka(Stavka stavka) {
		getStavkas().add(stavka);
		stavka.setLek(this);

		return stavka;
	}

	public Stavka removeStavka(Stavka stavka) {
		getStavkas().remove(stavka);
		stavka.setLek(null);

		return stavka;
	}

}