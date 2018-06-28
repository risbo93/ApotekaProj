package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the osoba database table.
 * 
 */
@Entity
@NamedQuery(name="Osoba.findAll", query="SELECT o FROM Osoba o")
public class Osoba implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_osoba")
	private int idOsoba;

	@Column(name="br_telefona")
	private String brTelefona;

	private int godine;

	private String grad;

	private String ime;

	private String prezime;

	private String ulica;

	private String uloga;

	//bi-directional many-to-one association to Komentar
	@OneToMany(mappedBy="osoba")
	private List<Komentar> komentars;

	//bi-directional many-to-one association to Kupovina
	@OneToMany(mappedBy="osoba")
	private List<Kupovina> kupovinas;

	//bi-directional many-to-one association to Korisnik
	@ManyToOne
	private Korisnik korisnik;

	//bi-directional many-to-many association to Stavka
	@ManyToMany
	@JoinTable(
		name="stavka_has_osoba"
		, joinColumns={
			@JoinColumn(name="osoba_id_osoba")
			}
		, inverseJoinColumns={
			@JoinColumn(name="stavka_id_stavka")
			}
		)
	private List<Stavka> stavkas;

	public Osoba() {
	}

	public int getIdOsoba() {
		return this.idOsoba;
	}

	public void setIdOsoba(int idOsoba) {
		this.idOsoba = idOsoba;
	}

	public String getBrTelefona() {
		return this.brTelefona;
	}

	public void setBrTelefona(String brTelefona) {
		this.brTelefona = brTelefona;
	}

	public int getGodine() {
		return this.godine;
	}

	public void setGodine(int godine) {
		this.godine = godine;
	}

	public String getGrad() {
		return this.grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getIme() {
		return this.ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return this.prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUlica() {
		return this.ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getUloga() {
		return this.uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

	public List<Komentar> getKomentars() {
		return this.komentars;
	}

	public void setKomentars(List<Komentar> komentars) {
		this.komentars = komentars;
	}

	public Komentar addKomentar(Komentar komentar) {
		getKomentars().add(komentar);
		komentar.setOsoba(this);

		return komentar;
	}

	public Komentar removeKomentar(Komentar komentar) {
		getKomentars().remove(komentar);
		komentar.setOsoba(null);

		return komentar;
	}

	public List<Kupovina> getKupovinas() {
		return this.kupovinas;
	}

	public void setKupovinas(List<Kupovina> kupovinas) {
		this.kupovinas = kupovinas;
	}

	public Kupovina addKupovina(Kupovina kupovina) {
		getKupovinas().add(kupovina);
		kupovina.setOsoba(this);

		return kupovina;
	}

	public Kupovina removeKupovina(Kupovina kupovina) {
		getKupovinas().remove(kupovina);
		kupovina.setOsoba(null);

		return kupovina;
	}

	public Korisnik getKorisnik() {
		return this.korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public List<Stavka> getStavkas() {
		return this.stavkas;
	}

	public void setStavkas(List<Stavka> stavkas) {
		this.stavkas = stavkas;
	}

}