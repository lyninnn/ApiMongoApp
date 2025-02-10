package com.example.Pokemon.repositories;

import com.example.Pokemon.models.Player;
import com.example.Pokemon.models.PokemonEquipo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface PlayerRepository extends MongoRepository<Player, String> {

    List<PokemonEquipo> findByEquipo(String nombrePokemon);
    List<Player> findByNivelGreaterThanEqual(int nivel);
    List<Player> findByLogrosNombre(String nombreLogro);

    int countByNivelGreaterThanEqual(int nivel);

    Optional<Player> findByNombre(String nombre);

    Player save(Player player);
    void deleteById(String id);
    void deleteByNombre(String nombre);
}

