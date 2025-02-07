package com.example.Pokemon.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
public class PokemonDTO {

    @Field(name = "name")
    @Schema(description = "Nombre del Pokémon", example = "Pikachu")
    private String nombre;

    @Schema(description = "Tipo del Pokémon", example = "Eléctrico")
    private String tipo;

    @Schema(description = "Nivel del Pokémon", example = "30")
    private int nivel;

    @Schema(description = "Ataques del Pokémon")
    private List<AtaqueDTO> ataques;


}
