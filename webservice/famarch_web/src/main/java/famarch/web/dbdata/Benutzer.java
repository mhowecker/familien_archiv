package famarch.web.dbdata;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Benutzer")
public class Benutzer {

	@Id
	String name;
	String berechtigung;
	String passwort;

	public Benutzer(String name, String berechtigung, String passwort) {
		super();
		this.name = name;
		this.berechtigung = berechtigung;
		this.passwort = passwort;
	}

	public Benutzer() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBerechtigung() {
		return berechtigung;
	}

	public void setBerechtigung(String berechtigung) {
		this.berechtigung = berechtigung;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

}
