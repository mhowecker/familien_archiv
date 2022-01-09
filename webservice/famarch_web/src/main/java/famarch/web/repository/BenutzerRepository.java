package famarch.web.repository;

import famarch.web.dbdata.Benutzer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BenutzerRepository extends CrudRepository<Benutzer, String> {
    Optional<Benutzer> findBenutzerByName(String name);

    Boolean existsByName(String name);
}
