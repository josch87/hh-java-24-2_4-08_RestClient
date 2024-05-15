package com.aljoschazoeller.java.hhjava242_408_restclient.rickmortyapi.domain;

import java.util.List;

public record RickMortyApiResponse(
        List<RickMortyApiCharacter> results
) {
}
