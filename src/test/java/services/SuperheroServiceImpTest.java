package services;

import model.Superhero;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
@RunWith(MockitoJUnitRunner.Silent.class)
public class SuperheroServiceImpTest {

    @InjectMocks
    private SuperheroServiceImp superHeroesServiceImp;

    @Mock
    private SuperheroRepository superheroRepository;

    private List<Superhero> superheroList = new ArrayList<Superhero>();

    @Before
    public void preloadDate() {
        Superhero hero1 = new Superhero("Superman");
        Superhero hero2 = new Superhero("Batman");
        Superhero hero3 = new Superhero("Wonderwoman");
        superheroList.add(hero1);
        superheroList.add(hero2);
        superheroList.add(hero3);
    }
    @After
    public void cleanData() {
        superheroList = new ArrayList<Superhero>();
    }

    @Test
    public void getValidFileredHeroByNameAllResults() {
        when(superheroRepository.findAll()).thenReturn(superheroList);
        List<Superhero> resultSuperHeroList = superHeroesServiceImp.filterHeroByName("man");
        Assert.assertEquals(resultSuperHeroList.size(), 3);
    }

    @Test
    public void getValidFileredHeroByNameUniqueResult() {
        when(superheroRepository.findAll()).thenReturn(superheroList);
        List<Superhero> resultSuperHeroList = superHeroesServiceImp.filterHeroByName("woman");
        Assert.assertEquals(resultSuperHeroList.size(), 1);
    }

    @Test
    public void getValidFileredHeroByNameNoResult() {
        when(superheroRepository.findAll()).thenReturn(superheroList);
        List<Superhero> resultSuperHeroList = superHeroesServiceImp.filterHeroByName("ironman");
        Assert.assertEquals(resultSuperHeroList.size(), 0);
    }

    @Test
    public void getValidFileredHeroByNameUppercase() {
        when(superheroRepository.findAll()).thenReturn(superheroList);
        List<Superhero> resultSuperHeroList = superHeroesServiceImp.filterHeroByName("bat");
        Assert.assertEquals(resultSuperHeroList.size(), 1);
    }
}
