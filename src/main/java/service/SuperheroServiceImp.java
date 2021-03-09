package service;

import model.Superhero;
import org.springframework.beans.factory.annotation.Autowired;
import repository.SuperheroRepository;

import java.util.ArrayList;
import java.util.List;

public class SuperheroServiceImp {

    @Autowired
    private SuperheroRepository superheroRepository;

    public List<Superhero> filterHeroByName(String nameFilter) {
        List<Superhero> superheroList = superheroRepository.findAll();
        List<Superhero> superheroListFiltered = new ArrayList<Superhero>();
        for (Superhero superhero: superheroList) {
            if (superhero.getName().contains(nameFilter)) {
                superheroListFiltered.add(superhero);
            }
        }
        return superheroListFiltered;
    }

}
