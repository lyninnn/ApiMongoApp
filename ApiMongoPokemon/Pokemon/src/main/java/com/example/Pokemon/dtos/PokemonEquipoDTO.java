package com.example.Pokemon.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "players")
public class PokemonEquipoDTO {

    @Schema(description = "ID del Pokémon", example = "67a38eb6d41661b5ce072f8b")
    @Field(name = "equipo.pokemon_id")
    private String pokemonId;

    @Schema(description = "Apodo del Pokémon", example = "Char")
    @Field(name = "equipo.apodo")
    private String apodo;
}
