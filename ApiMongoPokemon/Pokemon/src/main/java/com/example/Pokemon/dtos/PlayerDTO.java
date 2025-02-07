package com.example.Pokemon.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
public class PlayerDTO {

    @Field(name = "name")
    @Schema(description = "Nombre del jugador", example = "Ash Lin")
    private String nombre;

    @Schema(description = "Nivel del jugador", example = "24")
    private int nivel;

    @Schema(description = "Equipo de Pokémon del jugador")
    private List<PokemonEquipoDTO> equipo;

    @Schema(description = "Logros del jugador")
    private List<LogroDTO> logros;




}
