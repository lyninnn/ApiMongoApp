package com.example.Pokemon.models;

import com.example.Pokemon.dtos.AtaqueDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



import java.util.List;

@Data
@Document(collection = "Pokemon")
public class Pokemon {

    @Id
    @Schema(description = "ID único del Pokemon", example = "67a3af56d41661b5ce072fe5")
    private String id;

    @Schema(description = "Nombre del Pokémon", example = "Pikachu")
    private String nombre;

    @Schema(description = "Tipo del Pokémon", example = "Eléctrico")
    private String tipo;

    @Schema(description = "Nivel del Pokémon", example = "30")
    private int nivel;

    @Schema(description = "Estadisticas del Pokémon")
    private Estadistica estadisticas;

    @Schema(description = "Lista de ataques del Pokémon")
    private List<Ataque> ataques;

}
