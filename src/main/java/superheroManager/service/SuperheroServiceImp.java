package superheroManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import superheroManager.model.Superhero;
import superheroManager.repository.SuperheroRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SuperheroServiceImp implements SuperheroService {

    @Autowired
    private SuperheroRepository superheroRepository;

    public List<Superhero> filterHeroByName(String nameFilter) {
        List<Superhero> superheroList = getAllHeroes();
        List<Superhero> superheroListFiltered = new ArrayList<Superhero>();
        for (Superhero superhero: superheroList) {
            if (superhero.getName().toLowerCase().contains(nameFilter)) {
                superheroListFiltered.add(superhero);
            }
        }
        return superheroListFiltered;
    }

    public List<Superhero> getHeroes() {
        return getAllHeroes();
    }

    public Optional<Superhero> getSuperHero(Long id) {
        return superheroRepository.findById(id);
    }

    public String deleteSuperHero(Long id) {
        if (superheroRepository.findById(id).isPresent()) {
            superheroRepository.deleteById(id);
            return "SuperheroManager.model.Superhero deleted.";
        }
        return "Error! The superhero doesn't exist";
    }

    public String updateSuperHero(Superhero superHeroUpdate) {
        Long id = superHeroUpdate.getId();
        if (superheroRepository.findById(id).isPresent()) {
            Optional<Superhero> superheroUpdate = superheroRepository.findById(id);
            superheroUpdate.get().setName(superHeroUpdate.getName());
            superheroRepository.save(superHeroUpdate);
            return "Superhero modified";
        }
        return "Error! The superhero doesn't exist";
    }

    private List<Superhero> getAllHeroes() {
        return superheroRepository.findAll();
    }
}
