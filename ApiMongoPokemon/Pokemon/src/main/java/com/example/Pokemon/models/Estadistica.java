package com.example.Pokemon.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data

public class Estadistica {

    @Schema(description = "Puntos de vida del Pokémon", example = "35")
    private int hp;

    @Schema(description = "Puntos de ataque del Pokémon", example = "55")
    private int ataque;

    @Schema(description = "Puntos de defensa del Pokémon", example = "40")
    private int defensa;

    @Schema(description = "Velocidad del Pokémon", example = "90")
    private int velocidad;
}
