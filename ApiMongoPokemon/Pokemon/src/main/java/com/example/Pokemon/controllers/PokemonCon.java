package com.example.Pokemon.controllers;

import com.example.Pokemon.dtos.PokemonDTO;
import com.example.Pokemon.models.Pokemon;
import com.example.Pokemon.services.PokemonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pokemon")
@Tag(name = "Pokemon", description = "API REST para gestionar Pokémones")
public class PokemonCon {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping()
    @Operation(summary = "Obtener todos los Pokémones", description = "Devuelve una lista de todos los Pokémones disponibles")
    public List<Pokemon> getPokemons() {
        return pokemonService.getAllPokemons();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener Pokémon por ID", description = "Devuelve un Pokémon según su ID")
    public Optional<Pokemon> getPokemonById(@PathVariable("id") String id) {
        Optional<Pokemon> pokemon = pokemonService.getPokemonById(id);
        return pokemon;
    }

    @GetMapping("/name/{nombre}")
    @Operation(summary = "Buscar Pokémon por nombre", description = "Devuelve un Pokémon según su nombre")
    public Optional<Pokemon> getPokemonByName(@PathVariable("nombre") String nombre) {
        Optional<Pokemon> pokemon = pokemonService.getPokemonByNombre(nombre);
        return pokemon;
    }

    @GetMapping("/type/{tipo}")
    @Operation(summary = "Buscar Pokémon por tipo", description = "Devuelve una lista de Pokémon según el tipo especificado")
    public List<Pokemon> getPokemonsByType(@PathVariable("tipo") String tipo) {
        return pokemonService.getPokemonsByTipo(tipo);
    }

    @GetMapping("/level")
    @Operation(summary = "Buscar Pokémon por nivel", description = "Devuelve una lista de Pokémon cuyo nivel es mayor o igual al especificado")
    public List<Pokemon> getPokemonsByLevel(@RequestParam(value = "level") int level) {
        return pokemonService.getPokemonsByNivelGreaterThan(level);
    }

    @PostMapping("/insert")
    @Operation(summary = "Registrar un nuevo Pokémon", description = "Inserta un nuevo Pokémon en la base de datos")
    public ResponseEntity<String> registerPokemon(@RequestBody PokemonDTO pokemonDTO) {
        boolean isRegistered = pokemonService.register(pokemonDTO);
        if(isRegistered){
            return new ResponseEntity<>("Se ha insertado correctamente", HttpStatus.OK);

        }else{
            return new ResponseEntity<>("NO ha insertado correctamente", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un Pokémon por ID", description = "Elimina un Pokémon de la base de datos según su ID")
    public ResponseEntity<String> deletePokemonById(@PathVariable("id") String id) {
        boolean isDeleted = pokemonService.deletePokemonById(id);
        if(isDeleted){
            return new ResponseEntity<>(id, HttpStatus.OK);

        }else{
            return new ResponseEntity<>(id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    @Operation(summary = "Eliminar un Pokémon por nombre", description = "Elimina un Pokémon de la base de datos según su nombre")
    public ResponseEntity<String> deletePokemonByName(@RequestParam("name") String name) {
        boolean isDeleted = pokemonService.deletePokemonByNombre(name);
        if(isDeleted){
            return new ResponseEntity<>(name, HttpStatus.OK);

        }else{
            return new ResponseEntity<>(name, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    @Operation(summary = "Actualizar un Pokémon", description = "Modifica un Pokémon existente en la base de datos")
    public ResponseEntity<PokemonDTO> updatePokemon(@PathVariable("id") String id, @RequestBody PokemonDTO pokemonDTO) {
        try {
            pokemonService.updatePokemon(id, pokemonDTO);
            return new ResponseEntity<>(pokemonDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/updatePatch/{id}")
    @Operation(summary = "Modificar parcialmente un Pokémon", description = "Actualiza algunos campos de un Pokémon existente")
    public ResponseEntity<PokemonDTO> patchPokemon(@PathVariable("id") String id, @RequestBody PokemonDTO pokemonDTO) {
        try {
            pokemonService.patchPokemon(id, pokemonDTO);
            return new ResponseEntity<>(pokemonDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id/{id}")
    @Operation(summary = "Buscar un Pokémon por ID usando MongoTemplate", description = "Devuelve un Pokémon específico según su ID")
    public Pokemon getPokemonByIdCustom(@PathVariable("id") String id) {
        Pokemon pokemon = pokemonService.getPokemonByIdCustom(id);
        return pokemon;
    }

    @GetMapping("/levelAbove")
    @Operation(summary = "Buscar Pokémon por nivel usando MongoTemplate", description = "Devuelve una lista de Pokémon cuyo nivel es mayor que el especificado")
    public List<Pokemon> getPokemonsByLevelAbove(@RequestParam("level") int level) {
        return pokemonService.getPokemonNamesByNivelGreaterThan(level);
    }

    @GetMapping("/countByType/{tipo}")
    @Operation(summary = "Contar Pokémon por tipo", description = "Devuelve la cantidad de Pokémon según el tipo especificado")
    public ResponseEntity<Integer> countPokemonsByTipo(@PathVariable("tipo") String tipo) {
        int count = pokemonService.countPokemonsByTipo(tipo);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

}

