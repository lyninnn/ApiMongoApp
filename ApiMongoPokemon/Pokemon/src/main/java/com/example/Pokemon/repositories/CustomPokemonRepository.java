package com.example.Pokemon.repositories;

import com.example.Pokemon.models.Pokemon;

import java.util.List;

public interface CustomPokemonRepository {
    Pokemon findById(String id);
    List<Pokemon> findPokemonsByNivelGreaterThan(int nivel);

}
