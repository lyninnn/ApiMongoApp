package com.example.Pokemon.repositories;

import com.example.Pokemon.models.Player;

import java.util.List;

public interface CustomPlayerRepository {
    Player findById(String id);
    List<Player> findPlayersByNivelGreaterThan(int nivel);
}
