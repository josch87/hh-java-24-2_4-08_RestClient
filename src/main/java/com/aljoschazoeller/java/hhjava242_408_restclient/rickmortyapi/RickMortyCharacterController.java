package com.aljoschazoeller.java.hhjava242_408_restclient.rickmortyapi;

import com.aljoschazoeller.java.hhjava242_408_restclient.rickmortyapi.domain.RickMortyApiCharacter;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/characters")
public class RickMortyCharacterController {

    private final RickMortyApiService rickMortyApiService;

    public RickMortyCharacterController(RickMortyApiService rickMortyApiService) {
        this.rickMortyApiService = rickMortyApiService;
    }

    @GetMapping
    public List<RickMortyApiCharacter> getAllFilteredCharacters(@RequestParam Map<String, String> parameters) {
        if (parameters.isEmpty()) {
            return rickMortyApiService.loadAllCharacters().results();
        }
        return rickMortyApiService.loadFilteredCharacters(parameters).results();
    }

    @GetMapping("{id}")
    public RickMortyApiCharacter getCharacterById(@PathVariable int id) {
        return rickMortyApiService.loadSingleCharacterById(id);
    }
}
