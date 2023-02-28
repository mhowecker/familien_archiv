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
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
        PersonLong pl = new PersonLong();
        try (Session session = this.setupDB()) {
            session.beginTransaction();
            String query = "from Person where id=" + id;
            List result = session.createQuery(query).list();
            for (Person p : (List<Person>) result) {
                mapPersonPersonLong(p, pl);
                break;
            }

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

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pl;
    }

    private static void mapPersonPersonLong(Person person_from, Person person_to) {
        person_to.setId(person_from.getId());
        person_to.setVorname(person_from.getVorname());
        person_to.setNachname(person_from.getNachname());
        person_to.setMaedchenname(person_from.getMaedchenname());
        person_to.setRufname(person_from.getRufname());
        person_to.setZusaetzliche_professionelle_taetigkeit(person_from.getZusaetzliche_professionelle_taetigkeit());
        person_to.setGeboren_am(person_from.getGeboren_am());
        person_to.setBegraebnis_am(person_from.getBegraebnis_am());
        person_to.setMutter(person_from.getMutter());
        person_to.setVater(person_from.getVater());
        person_to.setTitel(person_from.getTitel());
        person_to.setIdentifizierung(person_from.getIdentifizierung());
        person_to.setTodesursache(person_from.getTodesursache());
        person_to.setBeruf(person_from.getBeruf());
        person_to.setAusbildung(person_from.getAusbildung());
        person_to.setVerstorben_am(person_from.getVerstorben_am());
        person_to.setKonfession(person_from.getKonfession());
        person_to.setGeschlecht(person_from.getGeschlecht());
    }

    public boolean updatePerson(PersonLong person_neu) {

        Person person = new Person();
        mapPersonPersonLong(person_neu, person);

        List<Biographie> biographien = person_neu.getBiographien();
        List<Objekt> objekte = person_neu.getObjekte();
        List<Partnerschaft> partnerschaften = person_neu.getPartnerschaften();

        try (Session session = this.setupDB()) {
            session.beginTransaction();

            session.update(person);

            this.saveOrUpdateBio(biographien, session);
            this.saveOrUpdateObj(objekte, session);
            this.saveOrUpdatePart(partnerschaften, session);

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean insertPerson(PersonLong person_neu) {

        Person person = new Person();
        mapPersonPersonLong(person_neu, person);

        List<Biographie> biographien = person_neu.getBiographien();
        List<Objekt> objekte = person_neu.getObjekte();
        List<Partnerschaft> partnerschaften = person_neu.getPartnerschaften();

        try (Session session = this.setupDB()) {
            session.beginTransaction();

            session.saveOrUpdate(person);

            this.saveOrUpdateBio(biographien, session);
            this.saveOrUpdateObj(objekte, session);
            this.saveOrUpdatePart(partnerschaften, session);

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private void saveOrUpdateBio(List<Biographie> bio, Session session) {
        if (bio == null) return;
        for (Biographie b : bio) {
            session.saveOrUpdate(b);
        }
    }

    private void saveOrUpdateObj(List<Objekt> obj, Session session) {
        if (obj == null) return;
        for (Objekt o : obj) {
            session.saveOrUpdate(o);
        }
    }

    private void saveOrUpdatePart(List<Partnerschaft> part, Session session) {
        if (part == null) return;
        for (Partnerschaft p : part) {
            int personid1 = p.getPerson1();
            int personid2 = p.getPerson2();
            Query query = session.createQuery("from Person where id=:id");
            query.setParameter("id", personid1);
            List result = query.list();
            if (result.size() == 0) {
                Person person1 = new Person();
                person1.setId(personid1);
                session.save(person1);
                session.getTransaction().commit();
                session.getTransaction().begin();
            }
            query = session.createQuery("from Person where id=:id");
            query.setParameter("id", personid2);
            result = query.list();
            if (result.size() == 0) {
                Person person2 = new Person();
                person2.setId(personid2);
                session.save(person2);
                session.getTransaction().commit();
                session.getTransaction().begin();
            }
            session.saveOrUpdate(p);
        }
    }

    public boolean deletePerson(String id) {
        try (Session session = this.setupDB()) {
            Person person = new Person();
            person.setId(Integer.parseInt(id));
            session.getTransaction().begin();

            Query query = session.createQuery("delete from Biographie where person=:id");
            query.setParameter("id", person.getId());
            query.executeUpdate();

            query = session.createQuery("delete from Objekt where person=:id");
            query.setParameter("id", person.getId());
            query.executeUpdate();

            query = session.createQuery("from Partnerschaft where person1=:id or person2=:id");
            query.setParameter("id", person.getId());
            List result1 = query.list();
            for (Partnerschaft part : (List<Partnerschaft>) result1) {
                query = session.createQuery("from Person where id=:id");
                query.setParameter("id", part.getPerson1());
                List result2 = query.list();
                Person p1 = (Person) result2.get(0);

                query.setParameter("id", part.getPerson2());
                result2 = query.list();
                Person p2 = (Person) result2.get(0);

                if (p1.getId() == person.getId() && p2.getVorname() == null ||
                    p2.getId() == person.getId() && p1.getVorname() == null) {
                    session.delete(part);
                }

                session.getTransaction().commit();
                session.getTransaction().begin();

                if (p1.getId() != person.getId()) {
                    query = session.createQuery("from Partnerschaft where id=:id");
                    query.setParameter("id", p1.getId());
                    result2 = query.list();
                    if (result2.size() == 0) {
                        session.remove(p1);
                    }
                }
                if (p2.getId() != person.getId()) {
                    query = session.createQuery("from Partnerschaft where id=:id");
                    query.setParameter("id", p2.getId());
                    result2 = query.list();
                    if (result2.size() == 0) {
                        session.remove(p2);
                    }
                }

                session.getTransaction().commit();
                session.getTransaction().begin();
            }

            query = session.createQuery("from Partnerschaft where person1=:id or person2=:id");
            query.setParameter("id", person.getId());
            result1 = query.list();
            if (result1.size() == 0) {
                query = session.createQuery("delete from Person where id=:id");
                query.setParameter("id", person.getId());
                query.executeUpdate();
            } else {
                session.update(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}