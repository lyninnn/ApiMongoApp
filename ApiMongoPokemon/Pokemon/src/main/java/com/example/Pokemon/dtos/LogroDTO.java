package com.example.Pokemon.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class LogroDTO {
    @Schema(description = "Nombre del logro", example = "Campeón de Kanto")
    private String nombre;

    @Schema(description = "Fecha del logro", example = "2019-12-10")
    private String fecha;
}