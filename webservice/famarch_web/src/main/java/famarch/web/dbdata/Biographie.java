package famarch.web.dbdata;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Biographien")
public class Biographie {

	@Id
	int nummer;
	String titel;
	String kategorie;
	String dokument;
	int person;
	
	public Biographie(int nummer, String titel, String kategorie, String dokument, int person) {
		super();
		this.nummer = nummer;
		this.titel = titel;
		this.kategorie = kategorie;
		this.dokument = dokument;
		this.person = person;
	}

	public Biographie() {

	}

	public int getNummer() {
		return nummer;
	}
	public void setNummer(int nummer) {
		this.nummer = nummer;
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
	public String getDokument() {
		return dokument;
	}
	public void setDokument(String dokument) {
		this.dokument = dokument;
	}
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	
	
}
