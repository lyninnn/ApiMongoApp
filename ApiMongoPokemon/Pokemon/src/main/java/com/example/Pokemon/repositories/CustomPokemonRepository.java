package com.example.Pokemon.repositories;

import com.example.Pokemon.models.Pokemon;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface CustomPokemonRepository {
    public abstract Pokemon findById(String id);
    public abstract ArrayList<Pokemon> findPokemonByGreaterThan(double duration);
}
