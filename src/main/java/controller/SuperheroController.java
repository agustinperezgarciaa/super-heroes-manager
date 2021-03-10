package controller;

import model.Superhero;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.SuperheroService;


/**
 * @author Agustin Perez Garcia
 *
 */
@RestController
public class SuperheroController {

    @Autowired
    private SuperheroService superheroService;

//    @PostMapping("/createHero")
//    public ResponseEntity createNewClient(@Valid @RequestBody Superhero superhero) {
//        clientService.saveClient(client);
//        return ResponseEntity.status(HttpStatus.CREATED).body(client);
//    }

    @GetMapping("/getHeroes")
    public ResponseEntity getHeroes() {
        List<Superhero> superheroes = superheroService.getHeroes();
        return ResponseEntity.ok(superheroes);
    }

    @GetMapping("/getHeroes")
    public ResponseEntity getHeroesById(@RequestParam Long id) {
        Optional<Superhero> superheroe = superheroService.getSuperHero(id);
        return ResponseEntity.ok(superheroe);
    }

    @GetMapping("/getFilteredHeroes")
    public ResponseEntity getFilteredHeroes(@RequestParam String filter) {
        List<Superhero> superheroes = superheroService.filterHeroByName(filter);
        return ResponseEntity.ok(superheroes);
    }

    @PutMapping("/updateHeroe")
    public ResponseEntity getFilteredHeroes(@RequestParam Superhero superhero) {
        String response = superheroService.updateSuperHero(superhero);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deleteHeroe")
    public ResponseEntity getFilteredHeroes(@RequestParam Long id) {
        String response = superheroService.deleteSuperHero(id);
        return ResponseEntity.ok(response);
    }
}