package service;

import model.Superhero;
import org.springframework.beans.factory.annotation.Autowired;
import repository.SuperheroRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
            return "Superhero deleted.";
        }
        return "Error! The superhero doesn't exist";
    }

    public String updateSuperHero(Superhero superHeroUpdate) {
        Long id = superHeroUpdate.getId();
        if (superheroRepository.findById(id).isPresent()) {
            Superhero superheroToUpdate = new Superhero();
            superheroToUpdate.setId(superheroToUpdate.getId());
            superheroToUpdate.setName(superheroToUpdate.getName());
            superheroRepository.save(superheroToUpdate);
            return "Superhero modified";
        }
        return "Error! The superhoero doesn't exist";
    }

    private List<Superhero> getAllHeroes() {
        return superheroRepository.findAll();
    }
}
