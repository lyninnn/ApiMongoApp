package com.example.Pokemon.repositories;

import com.example.Pokemon.models.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface PokemonRepository extends MongoRepository<Pokemon, String> {

    List<Pokemon> findByTipo(String tipo);
    List<Pokemon> findByNivelGreaterThanEqual(int nivel);
    List<Pokemon> findByEstadisticasVelocidadGreaterThan(int velocidad);
    List<Pokemon> findByAtaquesNombre(String nombreAtaque);

    int countByTipo(String tipo);

    Optional<Pokemon> findByNombre(String nombre);

    Pokemon save(Pokemon pokemon);
    void deleteById(String id);
    void deleteByNombre(String nombre);
}
