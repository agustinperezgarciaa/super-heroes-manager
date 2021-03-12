package superheroManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import superheroManager.dto.SuperheroDTO;
import superheroManager.exceptionHandler.RecordNotFoundException;
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
        List<Superhero> superheroListFiltered = new ArrayList<>();
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

    public void deleteSuperHero(Long id) {
        if (superheroRepository.findById(id).isPresent()) {
            superheroRepository.deleteById(id);
            return;
        }
        throw new RecordNotFoundException();
    }

    public Superhero updateSuperHero(Long id, SuperheroDTO superHeroNewData) {
        if (superheroRepository.findById(id).isPresent()) {
            Optional<Superhero> superheroUpdate = superheroRepository.findById(id);
            superheroUpdate.get().setName(superHeroNewData.getName());
            superheroRepository.save(superheroUpdate.get());
            return superheroUpdate.get();
        }
        throw new RecordNotFoundException();
    }

    private List<Superhero> getAllHeroes() {
        return superheroRepository.findAll();
    }
}
