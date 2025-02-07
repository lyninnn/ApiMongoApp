package com.example.Pokemon.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "Players")
public class Player {

    @Id
    @Schema(description = "ID único del jugador", example = "67a3af56d41661b5ce072fe5")
    private String id;

    @Field(name = "name")
    @Schema(description = "Nombre del jugador", example = "Ash Lin")
    private String nombre;

    @Schema(description = "Nivel del jugador", example = "24")
    private int nivel;

    @Schema(description = "Equipo de Pokémon del jugador")
    private List<PokemonEquipo> equipo;

    @Schema(description = "Logros del jugador")
    private List<Logro> logros;

}