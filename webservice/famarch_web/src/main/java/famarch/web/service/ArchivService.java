package famarch.web.service;

import famarch.web.webdata.BenutzerData;
import famarch.web.webdata.PersonDataShort;
import famarch.web.webdata.PersonLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Zwischenklasse zwischen Controller und Connector
 * leitet Anfragen von Controller an Connector weiter
 * sickt responses wieder in die andere Richtung
 */

@Service
public class ArchivService {

    @Autowired
    private ArchivConnector connector;

    public ArchivService() {

    }

    public PersonDataShort getOverview() {
        return this.connector.allPersonHandler();
    }

    public PersonDataShort getFilteredOverview(String filter) {
        return this.connector.filteredPersonHandler(filter);
    }

    public PersonLong getPersonLong(String id) {
        return this.connector.getPersonLong(id);
    }

    public BenutzerData getUserdata() {
        return connector.userHandler();
    }

    public boolean updatePerson(PersonLong person_neu) {
        return connector.updatePerson(person_neu);
    }

    public boolean insertPerson(PersonLong person_neu) {
        return connector.insertPerson(person_neu);
    }

    public boolean deletePerson(String id) {
        return connector.deletePerson(id);
    }
}
