package com.example.Pokemon.dtos;

import com.example.Pokemon.models.Ataque;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "pokemon")
public class PokemonDTO {

    @Id
    private String id;

    @Schema(description = "Nombre del Pokémon", example = "Pikachu")
    private String nombre;

    @Schema(description = "Tipo del Pokémon", example = "Eléctrico")
    private String tipo;

    @Schema(description = "Nivel del Pokémon", example = "30")
    private int nivel;

    @Schema(description = "Estadisticas del Pokémon")
    private EstadisticaDTO estadisticas;

    @Schema(description = "Ataques del Pokémon")
    private List<Ataque> ataques;


}
