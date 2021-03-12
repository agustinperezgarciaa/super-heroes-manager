package unit.services;

import superheroManager.model.Superhero;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import superheroManager.repository.SuperheroRepository;
import superheroManager.service.SuperheroServiceImp;

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
    private SuperheroServiceImp superheroServiceImp;

    @Mock
    private SuperheroRepository superheroRepository;

    private List<Superhero> superheroList = new ArrayList<>();

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
        superheroList = new ArrayList<>();
    }

    @Test
    public void getValidFilteredHeroByNameAllResults() {
        when(superheroRepository.findAll()).thenReturn(superheroList);
        List<Superhero> resultSuperHeroList = superheroServiceImp.filterHeroByName("man");
        Assert.assertEquals(3, resultSuperHeroList.size());
        Assert.assertEquals("Superman", resultSuperHeroList.get(0).getName());
        Assert.assertEquals("Batman", resultSuperHeroList.get(1).getName());
        Assert.assertEquals("Wonderwoman", resultSuperHeroList.get(2).getName());

    }

    @Test
    public void getValidFilteredHeroByNameUniqueResult() {
        when(superheroRepository.findAll()).thenReturn(superheroList);
        List<Superhero> resultSuperHeroList = superheroServiceImp.filterHeroByName("woman");
        Assert.assertEquals(1, resultSuperHeroList.size());
        Assert.assertEquals("Wonderwoman", resultSuperHeroList.get(0).getName());
    }

    @Test
    public void getValidFilteredHeroByNameNoResult() {
        when(superheroRepository.findAll()).thenReturn(superheroList);
        List<Superhero> resultSuperHeroList = superheroServiceImp.filterHeroByName("ironman");
        Assert.assertEquals(0, resultSuperHeroList.size());
    }

    @Test
    public void getValidFilteredHeroByNameUppercase() {
        when(superheroRepository.findAll()).thenReturn(superheroList);
        List<Superhero> resultSuperHeroList = superheroServiceImp.filterHeroByName("bat");
        Assert.assertEquals(1, resultSuperHeroList.size());
        Assert.assertEquals("Batman", resultSuperHeroList.get(0).getName());
    }
}
