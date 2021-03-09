package services;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SuperheroServiceImpTest {

    @InjectMocks
    private SuperheroServiceImp superHeroesServiceImp;

    private List<Superhero> superHeoreList;

    @Before
    public void preloadDate() {
        SuperHero hero1 = new Superhero("Superman");
        SuperHero hero2 = new Superhero("Batman");
        SuperHero hero3 = new Superhero("Wonderwoman");
    }

}
