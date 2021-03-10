package superheroManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import superheroManager.model.Superhero;

/**
 * @author Agustin Perez Garcia
 *
 */
@Repository
public interface SuperheroRepository extends JpaRepository<Superhero, Long> {

}