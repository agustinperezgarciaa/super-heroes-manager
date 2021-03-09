package repository;

import model.Superhero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Agustin Perez Garcia
 *
 */
@Repository
public interface SuperheroRepository extends JpaRepository<Superhero, Long> {

}