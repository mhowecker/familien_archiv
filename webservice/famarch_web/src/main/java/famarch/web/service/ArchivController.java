package famarch.web.service;

import famarch.web.webdata.BenutzerData;
import famarch.web.webdata.PersonDataShort;
import famarch.web.webdata.PersonLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Rest Controller
 * managet APIs
 */
@RestController
public class ArchivController {

    @Autowired
    private ArchivService service;

    /**
     * Schickt wichtigsten Daten aller gespeicherten Personen fuer einen Ueberblick
     * @return Liste der Daten aller Personen als JSON Objekt
     */

    @RequestMapping(value="/data/all", method=RequestMethod.GET)
    public PersonDataShort getOverview() {
        return service.getOverview();
    }

    /**
     * Schickt wichtigsten Daten aller gespeicherten Personen fuer eine Auswhal
     * Personen werden mit Suchbegriff gefiltert
     * Filter wird auf Vor- und Nachname angewendet
     * @param filter suchbegriff nach dem alle Personen gefiltert werden
     * @return Lister der Daten aller Personen, die den Suchbegriff im Vor- oder Nachnamen enthalten als JSON Objekt
     */

    @RequestMapping(value="/data/filter/{filter}", method=RequestMethod.GET)
    public PersonDataShort getFilteredOverviewBoth(@PathVariable(value="filter") String filter) {
        return service.getFilteredOverview(filter);
    }

    /**
     * Schickt alle Daten einer Person
     * @param id Person, deren Daten zurueckgegeben werde sollen
     * @return Alle Daten einer Person als JSON Objekt
     */
    @RequestMapping(value="/data/detail/{id}", method=RequestMethod.GET)
    public PersonLong getPersonLong(@PathVariable(value="id") String id) {
        return service.getPersonLong(id);
    }

    /**
     * Schickt eine Liste aller Benutzer
     * @return eine Liste aller Benutzer als JSON Objekt
     */

    @RequestMapping(value="/data/user", method=RequestMethod.GET)
    public BenutzerData getUserdata() {
        return service.getUserdata();
    }

    /**
     * Nimmt eine Person entgegen und updatet sie in der Datenbank
     * @param person_neu ueberarbeitete Person
     * @return true - wenn update erfolgreich, false - wenn update fehlgeschlagen
     */

    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public boolean updatePerson(@RequestBody PersonLong person_neu) {
        return service.updatePerson(person_neu);
    }

    /**
     * Nimmt eine Person entgegen und legt sie in der Datenbank ab
     * @param person_neu neue Person
     * @return true, wenn insert erfolgreich, false - wenn insert fehlgeschlagen
     */

    @RequestMapping(value="/insert", method=RequestMethod.PUT)
    public boolean insertPerson(@RequestBody PersonLong person_neu) {
        return service.insertPerson(person_neu);
    }

    /**
     * Loescht eine Person aus der Datenbank
     * @param id Person, die geloescht werden soll
     * @return true - wenn loeschen erfolgreich, false - wenn insert fehlgeschlagen
     */

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public boolean deletePerson(@PathVariable(value="id") String id) {
        return service.deletePerson(id);
    }
}
