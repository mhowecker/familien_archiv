package famarch.web.webdata;

import java.util.LinkedList;
import java.util.List;

public class PersonDataShort {
    private List<PersonShort> personenShort;

    public PersonDataShort() {
        this.personenShort = new LinkedList<PersonShort>();
    }

    public void setPersonenShort(List<PersonShort> personenShort) {
        this.personenShort = personenShort;
    }

    public List<PersonShort> getPersonenShort() {
        return this.personenShort;
    }

    public void addPersonShort(PersonShort personShort) {
        this.personenShort.add(personShort);
    }
}
