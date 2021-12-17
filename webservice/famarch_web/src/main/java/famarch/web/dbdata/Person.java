package famarch.web.dbdata;
import famarch.web.global.Umlaute;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="Personen")
public class Person {

	@Id
	@Column(name="id")
	int id;
	@Column(name="vorname")
	String vorname;
	@Column(name="nachname")
	String nachname;
	@Column(name="m" + Umlaute.auml_lower + "dchenname")
	String maedchenname;
	@Column(name="rufname")
	String rufname;
	@Column(name="zus" + Umlaute.auml_lower + "tzliche_professionelle_t" + Umlaute.auml_lower + "tigkeit")
	String zusaetzliche_professionelle_taetigkeit;
	@Column(name="geboren_am")
	Date geboren_am;
	@Column(name="begr" + Umlaute.auml_lower + "bnis_am")
	Date begraebnis_am;
	@Column(name="mutter")
	String mutter;
	@Column(name="vater")
	String vater;
	@Column(name="titel")
	String titel;
	@Column(name="identifizierung")
	String identifizierung;
	@Column(name="todesursache")
	String todesursache;
	@Column(name="beruf")
	String beruf;
	@Column(name="ausbildung")
	String ausbildung;
	@Column(name="trauung_am")
	Date traunung_am;
	@Column(name="verstorben_am")
	Date verstorben_am;
	@Column(name="konfession")
	String konfession;
	@Column(name="geschlecht")
	String geschlecht;

	public Person(int id, String vorname, String nachname, String maedchenname, String rufname,
			String zusaetzliche_professionelle_taetigkeit, Date geboren_am, Date begraebnis_am, String mutter,
			String vater, String titel, String identifizierung, String todesursache, String beruf, String ausbildung,
			Date traunung_am, Date verstorben_am, String konfession, String geschlecht) {
		super();
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.maedchenname = maedchenname;
		this.rufname = rufname;
		this.zusaetzliche_professionelle_taetigkeit = zusaetzliche_professionelle_taetigkeit;
		this.geboren_am = geboren_am;
		this.begraebnis_am = begraebnis_am;
		this.mutter = mutter;
		this.vater = vater;
		this.titel = titel;
		this.identifizierung = identifizierung;
		this.todesursache = todesursache;
		this.beruf = beruf;
		this.ausbildung = ausbildung;
		this.traunung_am = traunung_am;
		this.verstorben_am = verstorben_am;
		this.konfession = konfession;
		this.geschlecht = geschlecht;
	}

	public Person() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getMaedchenname() {
		return maedchenname;
	}

	public void setMaedchenname(String maedchenname) {
		this.maedchenname = maedchenname;
	}

	public String getRufname() {
		return rufname;
	}

	public void setRufname(String rufname) {
		this.rufname = rufname;
	}

	public String getZusaetzliche_professionelle_taetigkeit() {
		return zusaetzliche_professionelle_taetigkeit;
	}

	public void setZusaetzliche_professionelle_taetigkeit(String zusaetzliche_professionelle_taetigkeit) {
		this.zusaetzliche_professionelle_taetigkeit = zusaetzliche_professionelle_taetigkeit;
	}

	public Date getGeboren_am() {
		return geboren_am;
	}

	public void setGeboren_am(Date geboren_am) {
		this.geboren_am = geboren_am;
	}

	public Date getBegraebnis_am() {
		return begraebnis_am;
	}

	public void setBegraebnis_am(Date begraebnis_am) {
		this.begraebnis_am = begraebnis_am;
	}

	public String getMutter() {
		return mutter;
	}

	public void setMutter(String mutter) {
		this.mutter = mutter;
	}

	public String getVater() {
		return vater;
	}

	public void setVater(String vater) {
		this.vater = vater;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getIdentifizierung() {
		return identifizierung;
	}

	public void setIdentifizierung(String identifizierung) {
		this.identifizierung = identifizierung;
	}

	public String getTodesursache() {
		return todesursache;
	}

	public void setTodesursache(String todesursache) {
		this.todesursache = todesursache;
	}

	public String getBeruf() {
		return beruf;
	}

	public void setBeruf(String beruf) {
		this.beruf = beruf;
	}

	public String getAusbildung() {
		return ausbildung;
	}

	public void setAusbildung(String ausbildung) {
		this.ausbildung = ausbildung;
	}

	public Date getTraunung_am() {
		return traunung_am;
	}

	public void setTraunung_am(Date traunung_am) {
		this.traunung_am = traunung_am;
	}

	public Date getVerstorben_am() {
		return verstorben_am;
	}

	public void setVerstorben_am(Date verstorben_am) {
		this.verstorben_am = verstorben_am;
	}

	public String getKonfession() {
		return konfession;
	}

	public void setKonfession(String konfession) {
		this.konfession = konfession;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}

}
