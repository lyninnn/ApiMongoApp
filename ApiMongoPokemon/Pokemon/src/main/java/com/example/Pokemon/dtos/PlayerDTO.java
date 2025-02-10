package com.example.Pokemon.dtos;

import com.example.Pokemon.models.Logro;
import com.example.Pokemon.models.PokemonEquipo;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
public class PlayerDTO {

    @Id
    private String id;


    @Schema(description = "Nombre del jugador", example = "Ash Lin")
    private String nombre;


    @Schema(description = "Nivel del jugador", example = "24")
    private int nivel;


    @Schema(description = "Equipo de Pokémon del jugador")
    private List<PokemonEquipo> equipo;


    @Schema(description = "Logros del jugador")
    private List<Logro> logros;




}
