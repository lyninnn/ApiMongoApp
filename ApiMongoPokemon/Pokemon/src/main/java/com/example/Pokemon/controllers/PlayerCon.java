package com.example.Pokemon.controllers;

import com.example.Pokemon.dtos.PlayerDTO;
import com.example.Pokemon.models.Player;
import com.example.Pokemon.services.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/player")
@Tag(name = "Player", description = "API REST para gestionar jugadores")
public class PlayerCon {

    @Autowired
    private PlayerService playerService;

    // Obtener todos los jugadores
    @GetMapping()
    @Operation(summary = "Obtener todos los jugadores", description = "Devuelve una lista de todos los jugadores disponibles")
    public List<Player> getPlayers() {
        return playerService.getAllPlayers();
    }

    // Obtener jugador por ID
    @GetMapping("/{id}")
    @Operation(summary = "Obtener jugador por ID", description = "Devuelve un jugador según su ID")
    public Optional<Player> getPlayerById(@PathVariable("id") String id) {
        Optional<Player> player = playerService.getPlayerById(id);
        return player;
    }

    // Buscar jugador por nombre
    @GetMapping("/name/{nombre}")
    @Operation(summary = "Buscar jugador por nombre", description = "Devuelve un jugador según su nombre")
    public Optional<Player> getPlayerByName(@PathVariable("nombre") String nombre) {
        Optional<Player> player = playerService.getPlayerByNombre(nombre);
        return player;
    }

    // Buscar jugadores por nivel
    @GetMapping("/level")
    @Operation(summary = "Buscar jugadores por nivel", description = "Devuelve una lista de jugadores cuyo nivel es mayor o igual al especificado")
    public List<Player> getPlayersByLevel(@RequestParam(value = "level") int level) {
        return playerService.getPlayersByNivelGreaterThan(level);
    }


    // Buscar jugadores por nombre de logro
    @GetMapping("/achievements")
    @Operation(summary = "Buscar jugadores por logro", description = "Devuelve una lista de jugadores que tienen un logro específico")
    public List<Player> getPlayersByAchievements(@RequestParam(value = "achievement") String achievement) {
        return playerService.getPlayersByLogrosNombre(achievement);
    }

    // Contar jugadores por nivel
    @GetMapping("/countByLevel")
    @Operation(summary = "Contar jugadores por nivel", description = "Devuelve la cantidad de jugadores cuyo nivel es mayor o igual al especificado")
    public ResponseEntity<Integer> countPlayersByLevel(@RequestParam(value = "level") int level) {
        int count = playerService.countPlayersByNivelGreaterThan(level);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    // Registrar un nuevo jugador
    @PostMapping("/insert")
    @Operation(summary = "Registrar un nuevo jugador", description = "Inserta un nuevo jugador en la base de datos")
    public ResponseEntity<String> registerPlayer(@RequestBody PlayerDTO playerDTO) {
        boolean isRegistered = playerService.register(playerDTO);
        if(isRegistered){
            return new ResponseEntity<>("Se ha insertado correctamente", HttpStatus.OK);

        }else{
            return new ResponseEntity<>("NO ha insertado correctamente", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Eliminar jugador por ID
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un jugador por ID", description = "Elimina un jugador de la base de datos según su ID")
    public ResponseEntity<String> deletePlayerById(@PathVariable("id") String id) {
        boolean isDeleted = playerService.deletePlayerById(id);
        if(isDeleted){
            return new ResponseEntity<>(id, HttpStatus.OK);

        }else{
            return new ResponseEntity<>(id, HttpStatus.INTERNAL_SERVER_ERROR);
        }    }

    // Eliminar jugador por nombre
    @DeleteMapping("/delete")
    @Operation(summary = "Eliminar un jugador por nombre", description = "Elimina un jugador de la base de datos según su nombre")
    public ResponseEntity<String> deletePlayerByName(@RequestParam("name") String name) {
        boolean isDeleted = playerService.deletePlayerByNombre(name);
        if(isDeleted){
            return new ResponseEntity<>(name, HttpStatus.OK);

        }else{
            return new ResponseEntity<>(name, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Actualizar un jugador
    @PutMapping("/update/{id}")
    @Operation(summary = "Actualizar un jugador", description = "Modifica un jugador existente en la base de datos")
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable("id") String id, @RequestBody PlayerDTO playerDTO) {
        try {
            playerService.updatePlayer(id, playerDTO);
            return new ResponseEntity<>(playerDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Actualizar parcialmente un jugador
    @PatchMapping("/updatePatch/{id}")
    @Operation(summary = "Modificar parcialmente un jugador", description = "Actualiza algunos campos de un jugador existente")
    public ResponseEntity<PlayerDTO> patchPlayer(@PathVariable("id") String id, @RequestBody PlayerDTO playerDTO) {
        try {
            playerService.patchPlayer(id, playerDTO);
            return new ResponseEntity<>(playerDTO, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Obtener jugador por ID usando MongoTemplate
    @GetMapping("/id/{id}")
    @Operation(summary = "Buscar un jugador por ID usando MongoTemplate", description = "Devuelve un jugador específico según su ID")
    public Player getPlayerByIdCustom(@PathVariable("id") String id) {
        Player player = playerService.getPlayerByIdCustom(id);
        return player;
    }

    // Buscar jugadores por nivel usando MongoTemplate
    @GetMapping("/levelAbove")
    @Operation(summary = "Buscar jugadores por nivel usando MongoTemplate", description = "Devuelve una lista de jugadores cuyo nivel es mayor que el especificado")
    public List<Player> getPlayersByLevelAbove(@RequestParam("level") int level) {
        return playerService.getPlayersByNivelGreaterThanCustom(level);
    }
}

