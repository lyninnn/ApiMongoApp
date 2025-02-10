package com.example.Pokemon.services;


import com.example.Pokemon.dtos.PokemonDTO;
import com.example.Pokemon.models.Pokemon;
import com.example.Pokemon.repositories.PokemonRepository;
import com.example.Pokemon.repositories.PokemonRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokemonRepositoryCustom pokemonRepositoryCustom;

    public List<Pokemon> getAllPokemons() {
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> getPokemonById(String id) {
        return pokemonRepository.findById(id);
    }

    public Optional<Pokemon> getPokemonByNombre(String nombre) {
        return pokemonRepository.findByNombre(nombre);
    }

    public List<Pokemon> getPokemonsByTipo(String tipo) {
        return pokemonRepository.findByTipo(tipo);
    }

    public List<Pokemon> getPokemonsByNivelGreaterThan(int nivel) {
        return pokemonRepository.findByNivelGreaterThanEqual(nivel);
    }

    public int countPokemonsByTipo(String tipo) {
        return pokemonRepository.countByTipo(tipo);
    }

    public boolean register(PokemonDTO pokemonDTO) {
        Pokemon pokemon = new Pokemon();
        pokemon.setNombre(pokemonDTO.getNombre());
        pokemon.setTipo(pokemonDTO.getTipo());
        pokemon.setNivel(pokemonDTO.getNivel());
        pokemon.setEstadisticas(pokemonDTO.getEstadisticas());
        pokemon.setAtaques(pokemonDTO.getAtaques());

        return pokemonRepository.save(pokemon) != null;
    }

    public boolean deletePokemonById(String id) {
        try {
            pokemonRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deletePokemonByNombre(String nombre) {
        try {
            pokemonRepository.deleteByNombre(nombre);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void updatePokemon(String id, PokemonDTO pokemonDTO) {
        Optional<Pokemon> pokemonOptional = pokemonRepository.findById(id);

        if (pokemonOptional.isPresent()) {
            Pokemon pokemon = pokemonOptional.get();
            pokemon.setNombre(pokemonDTO.getNombre());
            pokemon.setTipo(pokemonDTO.getTipo());
            pokemon.setNivel(pokemonDTO.getNivel());
            pokemon.setEstadisticas(pokemonDTO.getEstadisticas());
            pokemon.setAtaques(pokemonDTO.getAtaques());

            pokemonRepository.save(pokemon);
        } else {
            throw new RuntimeException("No existe el Pokémon con id: " + id);
        }
    }

    public void patchPokemon(String id, PokemonDTO pokemonDTO) {
        Optional<Pokemon> pokemonOptional = pokemonRepository.findById(id);

        if (pokemonOptional.isPresent()) {
            Pokemon pokemon = pokemonOptional.get();

            if (pokemonDTO.getNombre() != null) {
                pokemon.setNombre(pokemonDTO.getNombre());
            }
            if (pokemonDTO.getTipo() != null) {
                pokemon.setTipo(pokemonDTO.getTipo());
            }
            if (pokemonDTO.getNivel() != 0) {
                pokemon.setNivel(pokemonDTO.getNivel());
            }
            if (pokemonDTO.getEstadisticas() != null) {
                pokemon.setEstadisticas(pokemonDTO.getEstadisticas());
            }
            if (pokemonDTO.getAtaques() != null) {
                pokemon.setAtaques(pokemonDTO.getAtaques());
            }

            pokemonRepository.save(pokemon);
        } else {
            throw new RuntimeException("No existe el Pokémon con id: " + id);
        }
    }

    // Métodos usando MongoTemplate

    public Pokemon getPokemonByIdCustom(String id) {
        return pokemonRepositoryCustom.findById(id);
    }

    public List<Pokemon> getPokemonNamesByNivelGreaterThan(int nivel) {
        return pokemonRepositoryCustom.findPokemonsByNivelGreaterThan(nivel);
    }





}
