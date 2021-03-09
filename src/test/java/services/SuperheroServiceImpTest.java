package services;

import model.Superhero;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import repository.SuperheroRepository;
import service.SuperheroServiceImp;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * @author Agustin Perez Garcia
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class SuperheroServiceImpTest {

    @InjectMocks
    private SuperheroServiceImp superHeroesServiceImp;

    private List<Superhero> superheroList;

    private SuperheroRepository superheroRepository;

    @Before
    public void preloadDate() {
        Superhero hero1 = new Superhero("Superman");
        Superhero hero2 = new Superhero("Batman");
        Superhero hero3 = new Superhero("Wonderwoman");
        superheroList = new ArrayList<Superhero>();
        superheroList.add(hero1);
        superheroList.add(hero2);
        superheroList.add(hero3);
    }

    @Test
    public void getValidFileredHeroByName() {
        when(superheroRepository.findAll()).thenReturn(superheroList);
        List<Superhero> resultSuperHeroList = superHeroesServiceImp.filterHeroByName("man");
        Assert.assertEquals(resultSuperHeroList.size(), 2);
    }
}
