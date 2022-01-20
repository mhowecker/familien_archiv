package famarch.web.service;

import famarch.web.dbdata.Person;
import famarch.web.global.Umlaute;
import famarch.web.webdata.BenutzerData;
import famarch.web.webdata.PersonDataShort;
import famarch.web.webdata.PersonLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArchivController {

    @Autowired
    private ArchivService service;

    @RequestMapping(value="/data/all", method=RequestMethod.GET)
    public PersonDataShort getOverview() {
        return service.getOverview();
    }

    @RequestMapping(value="/data/filter/{filter}", method=RequestMethod.GET)
    public PersonDataShort getFilteredOverviewBoth(@PathVariable(value="filter") String filter) {
        return service.getFilteredOverview(filter);
    }

    @RequestMapping(value="/data/detail/{id}", method=RequestMethod.GET)
    public PersonLong getPersonLong(@PathVariable(value="id") String id) {
        return service.getPersonLong(id);
    }

    @RequestMapping(value="/data/user", method=RequestMethod.GET)
    public BenutzerData getUserdata() {
        return service.getUserdata();
    }

    @RequestMapping(value="/test/uml", method=RequestMethod.GET)
    public Umlaute getUmlaute() {
        return service.getUmlaute();
    }

    @RequestMapping(value="/update", method=RequestMethod.PUT)
    public boolean updatePerson(@RequestBody PersonLong person_neu) {
        return service.updatePerson(person_neu);
    }

    @RequestMapping(value="/insert", method=RequestMethod.PUT)
    public boolean insertPerson(@RequestBody PersonLong person_neu) {
        return service.insertPerson(person_neu);
    }

    @RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
    public boolean deletePerson(@PathVariable(value="id") String id) {
        return service.deletePerson(id);
    }

    @RequestMapping(value="/test/null", method=RequestMethod.GET)
    public Person getNull() {
        return service.getNull();
    }
}
