package famarch.web.webdata;

import java.sql.Date;

public class PersonShort {
    private int id;
    private String vorname;
    private String nachname;
    private Date geboren_am;
    private Date verstorben_am;

    public PersonShort(int id, String vorname, String nachname, Date geboren_am, Date verstorben_am) {
        this.id = id;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geboren_am = geboren_am;
        this.verstorben_am = verstorben_am;
    }

    public PersonShort() {

    }

    public int getId() {
        return id;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public Date getGeboren_am() {
        return geboren_am;
    }

    public Date getVerstorben_am() {
        return verstorben_am;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public void setGeboren_am(Date geboren_am) {
        this.geboren_am = geboren_am;
    }

    public void setVerstorben_am(Date verstorben_am) {
        this.verstorben_am = verstorben_am;
    }
}
