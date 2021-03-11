package superheroManager.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import superheroManager.annotations.LogExecutedTime;
import superheroManager.exceptionHandler.RecordNotFoundException;
import superheroManager.model.Superhero;
import superheroManager.service.SuperheroService;


/**
 * @author Agustin Perez Garcia
 *
 */
@RestController
public class SuperheroRestController extends ResponseEntityExceptionHandler {

    @Autowired
    private SuperheroService superheroService;

//    @PostMapping("/createHero")
//    public ResponseEntity createNewClient(@Valid @RequestBody SuperheroManager.model.Superhero superhero) {
//        clientService.saveClient(client);
//        return ResponseEntity.status(HttpStatus.CREATED).body(client);
//    }

    @GetMapping("/getHeroes")
    @LogExecutedTime
    @Cacheable("get-herores")
    public ResponseEntity getHeroes() {
        List<Superhero> superheroes = superheroService.getHeroes();
        return ResponseEntity.ok(superheroes);
    }

    @GetMapping("/getHero")
    @LogExecutedTime
    @Cacheable("get-hero")
    public ResponseEntity getHero(@RequestParam Long id) {
        Optional<Superhero> superheroe = superheroService.getSuperHero(id);
        if (!superheroe.isPresent()) {
            throw new RecordNotFoundException();
        }
        return ResponseEntity.ok(superheroe);
    }

    @GetMapping("/getFilteredHeroes")
    @LogExecutedTime
    @Cacheable("filter-hero")
    public ResponseEntity getFilteredHeroes(@RequestParam String filter) {
        List<Superhero> superheroes = superheroService.filterHeroByName(filter);
        return ResponseEntity.ok(superheroes);
    }

    @PutMapping("/updateHero")
    @LogExecutedTime
    @Cacheable("update-hero")
    public ResponseEntity updateHero(@RequestBody Superhero superhero) {
        String response = superheroService.updateSuperHero(superhero);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/deleteHero")
    @LogExecutedTime
    @Cacheable("delete-hero")
    public ResponseEntity deleteHero(@RequestParam Long id) {
        String response = superheroService.deleteSuperHero(id);
        return ResponseEntity.ok(response);
    }
}