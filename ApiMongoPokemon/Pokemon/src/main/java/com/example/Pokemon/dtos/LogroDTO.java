package com.example.Pokemon.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
public class LogroDTO {

    @Field(name = "nombre")
    @Schema(description = "Nombre del logro", example = "Campeón de Kanto")
    private String nombre;

    @Field(name = "fecha")
    @Schema(description = "Fecha del logro", example = "2019-12-10")
    private String fecha;
}