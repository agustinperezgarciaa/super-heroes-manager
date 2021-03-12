package superheroManager.service;


import superheroManager.dto.SuperheroDTO;
import superheroManager.model.Superhero;

import java.util.List;
import java.util.Optional;

public interface SuperheroService {

    List<Superhero> filterHeroByName(String nameFilter);

    List<Superhero> getHeroes();

    void deleteSuperHero(Long id);

    Optional<Superhero> getSuperHero(Long id);

    Superhero updateSuperHero(Long id, SuperheroDTO superHeroUpdate);
}
