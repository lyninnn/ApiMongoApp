package com.example.Pokemon.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Logro {
    @Schema(description = "Nombre del logro", example = "Campeón de Kanto")
    private String nombre;

    @Schema(description = "Fecha del logro", example = "2019-12-10")
    private LocalDate fecha;
}
