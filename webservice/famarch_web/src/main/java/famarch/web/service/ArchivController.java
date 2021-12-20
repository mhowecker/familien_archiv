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
}
