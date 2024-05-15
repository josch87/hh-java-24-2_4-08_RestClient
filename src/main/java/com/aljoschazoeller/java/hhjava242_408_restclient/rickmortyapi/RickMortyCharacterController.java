package com.aljoschazoeller.java.hhjava242_408_restclient.rickmortyapi;

import com.aljoschazoeller.java.hhjava242_408_restclient.rickmortyapi.domain.RickMortyApiCharacter;
import com.aljoschazoeller.java.hhjava242_408_restclient.rickmortyapi.domain.RickMortyApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/characters")
public class RickMortyCharacterController {

    private final RickMortyApiService rickMortyApiService;

    public RickMortyCharacterController(RickMortyApiService rickMortyApiService) {
        this.rickMortyApiService = rickMortyApiService;
    }

    @GetMapping
    public List<RickMortyApiCharacter> getAllCharacters() {
        return rickMortyApiService.loadAllCharacters().results();
    }
}
