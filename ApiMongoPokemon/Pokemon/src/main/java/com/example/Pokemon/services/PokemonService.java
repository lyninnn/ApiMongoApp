package com.example.Pokemon.services;


import com.example.Pokemon.repositories.PokemonRepository;
import com.example.Pokemon.repositories.PokemonRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokemonRepositoryCustom pokemonRepositoryCustom;







}
