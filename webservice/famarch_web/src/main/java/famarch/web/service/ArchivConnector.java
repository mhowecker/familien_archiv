package famarch.web.service;

import famarch.web.dbdata.*;
import famarch.web.webdata.BenutzerData;
import famarch.web.webdata.PersonDataShort;
import famarch.web.webdata.PersonLong;
import famarch.web.webdata.PersonShort;
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

    public PersonDataShort filteredPersonHandler(String filter) {
        PersonDataShort pds = null;
        try (Session session = this.setupDB()) {
            session.beginTransaction();
            String query = "from Person where vorname like '%" + filter + "%' or nachname like '%" + filter + "'";
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
            pl = mapPersonPersonLong(result);

            query = "from Biographie where person=" + pl.getId();
            result = session.createQuery(query).list();
            for (Biographie bio : (List<Biographie>) result) {
                pl.addBiographie(bio);
            }

            query = "from Objekt where person=" + pl.getId();
            result = session.createQuery(query).list();
            for (Objekt o : (List<Objekt>) result) {
                pl.addObjekt(o);
            }

            query = "from Partnerschaft where person1=" + pl.getId() + " or person2=" + pl.getId();
            result = session.createQuery(query).list();
            for (Partnerschaft ps : (List<Partnerschaft>) result) {
                pl.addPartnerschaft(ps);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pl;
    }

    private static PersonLong mapPersonPersonLong(List<Person> result) {
        PersonLong pl = new PersonLong();
        for (Person p : result) {
            pl.setId(p.getId());
            pl.setVorname(p.getVorname());
            pl.setNachname(p.getNachname());
            pl.setMaedchenname(p.getMaedchenname());
            pl.setRufname(p.getRufname());
            pl.setZusaetzliche_professionelle_taetigkeit(p.getZusaetzliche_professionelle_taetigkeit());
            pl.setGeboren_am(p.getGeboren_am());
            pl.setBegraebnis_am(p.getBegraebnis_am());
            pl.setMutter(p.getMutter());
            pl.setVater(p.getVater());
            pl.setTitel(p.getTitel());
            pl.setIdentifizierung(p.getIdentifizierung());
            pl.setTodesursache(p.getTodesursache());
            pl.setBeruf(p.getBeruf());
            pl.setAusbildung(p.getAusbildung());
            pl.setVerstorben_am(p.getVerstorben_am());
            pl.setKonfession(p.getKonfession());
            pl.setGeschlecht(p.getGeschlecht());
            break;
        }
        return pl;
    }
}