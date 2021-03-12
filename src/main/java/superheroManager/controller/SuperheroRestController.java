package superheroManager.controller;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import superheroManager.annotations.LogExecutedTime;
import superheroManager.cache.CacheActions;
import superheroManager.dto.SuperheroDTO;
import superheroManager.exceptionHandler.MissingParamException;
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

    @Autowired
    private CacheActions cacheActions;

    @GetMapping("/getHeroes")
    @LogExecutedTime
    @Cacheable(cacheNames = "get-heroes")
    public ResponseEntity getHeroes() {
        List<Superhero> superheroes = superheroService.getHeroes();
        return ResponseEntity.ok(superheroes);
    }

    @GetMapping("/getHero/{id}")
    @LogExecutedTime
    @Cacheable(cacheNames = "get-hero")
        public ResponseEntity getHero(@PathVariable Long id) {
        Optional<Superhero> superhero = superheroService.getSuperHero(id);
        if (!superhero.isPresent()) {
            throw new RecordNotFoundException();
        }
        return ResponseEntity.ok(superhero);
    }

    @GetMapping("/getFilteredHeroes")
    @LogExecutedTime
    @Cacheable(cacheNames = "get-filtered-heroes")
    public ResponseEntity getFilteredHeroes(@RequestParam String filter) {
        if (filter.isEmpty()) {
            throw new MissingParamException("Filter param missing");
        }
        List<Superhero> superheroes = superheroService.filterHeroByName(filter);
        return ResponseEntity.ok(superheroes);
    }

    @PutMapping("/updateHero/{id}")
    @LogExecutedTime
    @Cacheable(cacheNames = "update-hero")
    public ResponseEntity updateHero(@PathVariable Long id, @RequestBody SuperheroDTO superhero) {
        Superhero superheroUpdated = superheroService.updateSuperHero(id, superhero);
        cacheActions.evictAllCaches();
        return ResponseEntity.ok(superheroUpdated);
    }

    @DeleteMapping("/deleteHero/{id}")
    @LogExecutedTime
    @Cacheable(cacheNames = "delete-hero")
    public ResponseEntity deleteHero(@PathVariable Long id) {
        superheroService.deleteSuperHero(id);
        cacheActions.evictAllCaches();
        return ResponseEntity.ok().build();
    }
}