package com.example.Pokemon.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PokemonEquipo {
    @Schema(description = "ID del Pokémon", example = "67a38eb6d41661b5ce072f8b")
    private String pokemonId;

    @Schema(description = "Apodo del Pokémon", example = "Char")
    private String apodo;
}
