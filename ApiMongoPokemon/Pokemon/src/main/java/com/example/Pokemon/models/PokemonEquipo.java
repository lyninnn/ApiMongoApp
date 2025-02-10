package com.example.Pokemon.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "players")
public class PokemonEquipo {

    @Schema(description = "ID del Pokémon", example = "67a38eb6d41661b5ce072f8b")
    @Field(name = "equipo.pokemon_id")
    private String pokemonId;

    @Schema(description = "Apodo del Pokémon", example = "Char")
    private String apodo;
}
