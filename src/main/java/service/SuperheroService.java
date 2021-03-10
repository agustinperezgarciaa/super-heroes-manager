package service;

import model.Superhero;

import java.util.List;
import java.util.Optional;

public interface SuperheroService {

    public List<Superhero> filterHeroByName(String nameFilter);

    public List<Superhero> getHeroes();

    String deleteSuperHero(Long id);

    Optional<Superhero> getSuperHero(Long id);

    String updateSuperHero(Superhero superHeroUpdate);
}
