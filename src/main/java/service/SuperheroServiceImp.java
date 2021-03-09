package service;

import model.Superhero;
import org.springframework.beans.factory.annotation.Autowired;
import repository.SuperheroRepository;

import java.util.List;

public class SuperheroServiceImp {

    @Autowired
    private SuperheroRepository superheroRepository;

    public List<Superhero> filterHeroByName(String nameFilter) {
        List<Superhero> superheroList = superheroRepository.findAll();
        for (int i = 0; i < superheroList.size(); i++) {
            if (!superheroList.get(i).getName().contains(nameFilter)) {
                System.out.println(superheroList.get(i).getName());
                superheroList.remove(i);
                i --;
            }
        }
        return superheroList;
    }

}
