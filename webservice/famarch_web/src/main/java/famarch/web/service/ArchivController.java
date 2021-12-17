package famarch.web.service;

import famarch.web.global.Umlaute;
import famarch.web.webdata.BenutzerData;
import famarch.web.webdata.PersonDataShort;
import famarch.web.webdata.PersonLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArchivController {

    @Autowired
    private ArchivService service;

    @RequestMapping(value="/data/all", method=RequestMethod.GET)
    public PersonDataShort getOverview() {
        return service.getOverview();
    }

    @RequestMapping(value="/data/filter/vorname/{vorname}", method=RequestMethod.GET)
    public PersonDataShort getFilteredOverviewBoth(@PathVariable(value="vorname") String vorname) {
        return service.getFilteredOverview(vorname, "");
    }

    @RequestMapping(value="/data/filter/nachname/{nachname}", method=RequestMethod.GET)
    public PersonDataShort getFilteredOverview(@PathVariable(value="nachname") String nachname) {
        return service.getFilteredOverview("", nachname);
    }

    @RequestMapping(value="/data/filter/both/{vorname}/{nachname}", method=RequestMethod.GET)
    public PersonDataShort getFilteredOverview(@PathVariable(value="vorname") String vorname, @PathVariable(value="nachname") String nachname) {
        return service.getFilteredOverview(vorname, nachname);
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
}
