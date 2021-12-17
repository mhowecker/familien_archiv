package famarch.web.dbdata;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Objekte")
public class Objekt {

	@Id
	int nummer;
	int person;
	String titel;
	String kategorie;
	String ablageort;
	
	public Objekt(int nummer, int person, String titel, String kategorie, String ablageort) {
		super();
		this.nummer = nummer;
		this.person = person;
		this.titel = titel;
		this.kategorie = kategorie;
		this.ablageort = ablageort;
	}

	public Objekt() {

	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

	public int getPerson() {
		return person;
	}

	public void setPerson(int person) {
		this.person = person;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public String getAblageort() {
		return ablageort;
	}

	public void setAblageort(String ablageort) {
		this.ablageort = ablageort;
	}
	
	
}
