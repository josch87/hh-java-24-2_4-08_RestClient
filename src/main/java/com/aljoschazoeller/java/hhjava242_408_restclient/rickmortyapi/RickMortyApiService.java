package com.aljoschazoeller.java.hhjava242_408_restclient.rickmortyapi;

import com.aljoschazoeller.java.hhjava242_408_restclient.rickmortyapi.domain.RickMortyApiCharacter;
import com.aljoschazoeller.java.hhjava242_408_restclient.rickmortyapi.domain.RickMortyApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriBuilder;

import java.util.Map;

@Service
public class RickMortyApiService {
    private final RestClient restClient;

    public RickMortyApiService() {
        this.restClient = RestClient.builder()
                .baseUrl("https://rickandmortyapi.com/api")
                .build();
    }

    public RickMortyApiResponse loadAllCharacters() {
        return restClient.get()
                .uri("/character")
                .retrieve()
                .body(RickMortyApiResponse.class);
    }

    public RickMortyApiResponse loadFilteredCharacters(Map<String, String> parameters) {
        return restClient.get()
                .uri(uriBuilder -> {
                    UriBuilder builder = uriBuilder.path("/character");
                    parameters.forEach((builder::queryParam));
                    return builder.build();
                })
                .retrieve()
                .body(RickMortyApiResponse.class);
    }

    public RickMortyApiCharacter loadSingleCharacterById(int id) {
        return restClient.get()
                .uri(("/character/" + id))
                .retrieve()
                .body(RickMortyApiCharacter.class);
    }
}
