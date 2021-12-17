package famarch.web.webdata;

import famarch.web.dbdata.Person;

import java.util.LinkedList;
import java.util.List;

public class PersonData {
    private List<Person> personen;

    public PersonData() {
        this.personen = new LinkedList<Person>();
    }

    public void setPersonen(List<Person> personen) {
        this.personen = personen;
    }

    public List<Person> getPersonen() {
        return this.personen;
    }

    public void addPerson(Person person) {
        this.personen.add(person);
    }
}
