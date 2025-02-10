package com.example.Pokemon.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class PokemonEquipoDTO {
    @Field(name = "pokemon_id")
    @Schema(description = "ID del Pokémon", example = "67a38eb6d41661b5ce072f8b")
    private String pokemonId;

    @Field(name = "apodo")
    @Schema(description = "Apodo del Pokémon", example = "Char")
    private String apodo;
}
