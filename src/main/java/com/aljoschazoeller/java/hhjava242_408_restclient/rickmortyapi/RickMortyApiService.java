package com.aljoschazoeller.java.hhjava242_408_restclient.rickmortyapi;

import com.aljoschazoeller.java.hhjava242_408_restclient.rickmortyapi.domain.RickMortyApiResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

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
}
