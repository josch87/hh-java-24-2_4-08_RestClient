package com.aljoschazoeller.java.hhjava242_408_restclient.rickmortyapi;

import com.aljoschazoeller.java.hhjava242_408_restclient.rickmortyapi.domain.RickMortyApiCharacter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RickMortyCharacterController {

    private final RickMortyApiService rickMortyApiService;

    public RickMortyCharacterController(RickMortyApiService rickMortyApiService) {
        this.rickMortyApiService = rickMortyApiService;
    }

    @GetMapping("/characters")
    public List<RickMortyApiCharacter> getAllFilteredCharacters(@RequestParam Map<String, String> parameters) {
        if (parameters.isEmpty()) {
            return rickMortyApiService.loadAllCharacters().results();
        }
        return rickMortyApiService.loadFilteredCharacters(parameters).results();
    }

    @GetMapping("/characters/{id}")
    public RickMortyApiCharacter getCharacterById(@PathVariable int id) {
        return rickMortyApiService.loadSingleCharacterById(id);
    }

    @GetMapping("/species-statistic")
    public int getSpeciesStatistic(@RequestParam String species) {
        Map<String, String> filterVariable = Map.of("species", species);
        return rickMortyApiService.loadFilteredCharacters(filterVariable).info().count();
    }
}
