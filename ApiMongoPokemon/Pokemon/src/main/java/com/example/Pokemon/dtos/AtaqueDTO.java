package com.example.Pokemon.dtos;
import com.example.Pokemon.models.Ataque;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class AtaqueDTO extends Ataque {
    @Schema(description = "Nombre del ataque", example = "Hacerse adorable")
    private String nombre;

    @Schema(description = "Daño del ataque", example = "9999")
    private int daño;

}
