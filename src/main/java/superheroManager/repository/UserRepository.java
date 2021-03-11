package superheroManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import superheroManager.model.User;

import java.util.List;

/**
 * @author Agustin Perez Garcia
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByNameAndPassword(String name, String password);
}