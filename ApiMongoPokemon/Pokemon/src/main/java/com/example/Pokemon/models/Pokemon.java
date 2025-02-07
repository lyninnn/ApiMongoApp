package com.example.Pokemon.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;



import java.util.List;

@Data
@Document(collection = "Pokemon")
public class Pokemon {

    @Field(name = "name")
    @Schema(description = "Nombre del Pokémon", example = "Pikachu")
    private String nombre;

    @Schema(description = "Tipo del Pokémon", example = "Eléctrico")
    private String tipo;

    @Schema(description = "Nivel del Pokémon", example = "30")
    private int nivel;

    @Schema(description = "Lista de ataques del Pokémon")
    private List<Ataque> ataques;



}
