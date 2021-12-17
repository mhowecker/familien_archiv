package famarch.web.service;

import famarch.web.dbdata.Benutzer;
import famarch.web.dbdata.Person;
import famarch.web.webdata.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class ArchivConnector {

    private SessionFactory factory;
    private boolean setup = true;

    public Session setupDB()  {

        if (setup) {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
            try {
                factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            }
            catch (Exception e) {
                e.printStackTrace();
                StandardServiceRegistryBuilder.destroy(registry);
            }
            setup = false;
        }
        return factory.openSession();
    }

    public BenutzerData userHandler() {
        BenutzerData users = new BenutzerData();
        try (Session session = this.setupDB()) {
            session.beginTransaction();
            List result = session.createQuery("from Benutzer").list();
            for (Benutzer b : (List<Benutzer>) result) {

                /*Benutzer user = new Benutzer();
                user.setName(b.getName());
                user.setBerechtigung(b.getBerechtigung());
                user.setPasswort(b.getPasswort());
                users.addUser(user);*/

                users.addUser(b);
            }
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }

    public PersonDataShort allPersonHandler() {
        PersonDataShort pds = null;
        try (Session session = this.setupDB()) {
            session.beginTransaction();
            String query = "from Person";
            List result = session.createQuery(query).list();
            pds = ArchivConnector.convertPDS(result);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pds;
    }

    public PersonDataShort filteredPersonHandler(String vorname, String nachname) {
        PersonDataShort pds = null;
        try (Session session = this.setupDB()) {
            session.beginTransaction();
            String query = "from Person where vorname like '%" + vorname + "%' and nachname like '%" + nachname + "'";
            List result = session.createQuery(query).list();
            pds = ArchivConnector.convertPDS(result);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pds;
    }

    private static PersonDataShort convertPDS(List<Person> result) {
        PersonDataShort pds = new PersonDataShort();
        for (Person p : result) {
            PersonShort ps = new PersonShort();
            ps.setId(p.getId());
            ps.setVorname(p.getVorname());
            ps.setNachname(p.getNachname());
            ps.setGeboren_am(p.getGeboren_am());
            ps.setVerstorben_am(p.getVerstorben_am());
            pds.addPersonShort(ps);
        }
        return pds;
    }

    public PersonLong getPersonLong(String id) {
        PersonLong pl = null;
        try (Session session = this.setupDB()) {
            session.beginTransaction();
            String query = "from Person where id=" + id;
            List result = session.createQuery(query).list();
            pl = mapPersonPersonLonng(result);

            //Bios, Objekte und Partnerschafte fehlen noch
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pl;
    }

    private static PersonLong mapPersonPersonLonng(List<Person> result) {
        PersonLong pl = new PersonLong();
        for (Person p : result) {
            //Umwandlung noch nicht fertig
            break;
        }
        return pl;
    }
}