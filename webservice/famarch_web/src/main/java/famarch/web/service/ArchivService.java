package famarch.web.service;

import famarch.web.global.Umlaute;
import famarch.web.webdata.BenutzerData;
import famarch.web.webdata.PersonDataShort;
import famarch.web.webdata.PersonLong;
import org.springframework.stereotype.Service;

@Service
public class ArchivService {

    private ArchivConnector connector;

    public ArchivService() {
        this.connector = new ArchivConnector();
    }

    public PersonDataShort getOverview() {
        return this.connector.allPersonHandler();
    }

    public PersonDataShort getFilteredOverview(String vorname, String nachname) {
        return this.connector.filteredPersonHandler(vorname, nachname);
    }

    public PersonLong getPersonLong(String id) {
        return this.connector.getPersonLong(id);
    }

    public BenutzerData getUserdata() {
        return connector.userHandler();
    }

    public Umlaute getUmlaute() {
        return new Umlaute();
    }
}
