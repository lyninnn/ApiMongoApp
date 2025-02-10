package com.example.Pokemon.repositories;

import com.example.Pokemon.models.Pokemon;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface PokemonRepository extends MongoRepository<Pokemon,String> {
    ArrayList<Pokemon> findByTipo(String tipo);
    ArrayList<Pokemon> findTripsByNombre(String nombre);
    ArrayList<Pokemon> findTripsByOrigenAndDestination(String origen, String destination);
    ArrayList<Pokemon> findTripsByOrigenOrDestination(String origen, String destination); //En el caso de un OR
    int countTripsByOrigenOrDestination(String origen, String destino);
    ArrayList<Pokemon> findTripsByPriceLessThanEqual(double price); //Si quiero menor quitar ThanEqual

    Pokemon save(Pokemon trip);
    void deleteTripByNombre(String nombre);
    void deleteById(String id);
    Optional<Pokemon> findById(String id);
}
