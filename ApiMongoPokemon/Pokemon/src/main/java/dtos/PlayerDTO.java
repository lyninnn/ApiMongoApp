package dtos;

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

    @Data
    public static class PokemonEquipoDTO {
        @Schema(description = "ID del Pokémon", example = "67a38eb6d41661b5ce072f8b")
        private String pokemonId;

        @Schema(description = "Apodo del Pokémon", example = "Char")
        private String apodo;
    }

    @Data
    public static class LogroDTO {
        @Schema(description = "Nombre del logro", example = "Campeón de Kanto")
        private String nombre;

        @Schema(description = "Fecha del logro", example = "2019-12-10")
        private String fecha;
    }
}
