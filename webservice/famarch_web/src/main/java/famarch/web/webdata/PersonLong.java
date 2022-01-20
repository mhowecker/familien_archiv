package famarch.web.webdata;

import famarch.web.dbdata.Biographie;
import famarch.web.dbdata.Objekt;
import famarch.web.dbdata.Partnerschaft;
import famarch.web.dbdata.Person;

import java.sql.Date;
import java.util.*;

public class PersonLong extends Person {
    private List<Biographie> biographien;
    private List<Objekt> objekte;
    private List<Partnerschaft> partnerschaften;

    public PersonLong(int id, String vorname, String nachname, String maedchenname,
                      String rufname, String zusaetzliche_professionelle_taetigkeit,
                      Date geboren_am, Date begraebnis_am, String mutter, String vater,
                      String titel, String identifizierung, String todesursache, String beruf,
                      String ausbildung, Date verstorben_am, String konfession,
                      String geschlecht, List<Biographie> biographien, List<Objekt> objekte,
                      List<Partnerschaft> partnerschaften) {
        super(id, vorname, nachname, maedchenname, rufname, zusaetzliche_professionelle_taetigkeit,
                geboren_am, begraebnis_am, mutter, vater, titel, identifizierung, todesursache,
                beruf, ausbildung, verstorben_am, konfession, geschlecht);
        this.biographien = biographien;
        this.objekte = objekte;
        this.partnerschaften = partnerschaften;
    }

    public PersonLong() {
        super();
    }

    public void setBiographien(List<Biographie> biographien) {
        this.biographien = biographien;
    }

    public void setObjekte(List<Objekt> objekte) {
        this.objekte = objekte;
    }

    public void setPartnerschaften(List<Partnerschaft> partnerschaften) {
        this.partnerschaften = partnerschaften;
    }

    public List<Biographie> getBiographien() {
        return biographien;
    }

    public List<Objekt> getObjekte() {
        return objekte;
    }

    public List<Partnerschaft> getPartnerschaften() {
        return partnerschaften;
    }

    public void addBiographie(Biographie biographie) {
        if (this.biographien == null) this.biographien = new LinkedList<Biographie>();
        this.biographien.add(biographie);
    }

    public void addObjekt(Objekt objekt) {
        if (this.objekte == null) this.objekte= new LinkedList<Objekt>();
        this.objekte.add(objekt);
    }

    public void addPartnerschaft(Partnerschaft partnerschaft) {
        if (this.partnerschaften == null) this.partnerschaften = new LinkedList<Partnerschaft>();
        this.partnerschaften.add(partnerschaft);
    }
}
