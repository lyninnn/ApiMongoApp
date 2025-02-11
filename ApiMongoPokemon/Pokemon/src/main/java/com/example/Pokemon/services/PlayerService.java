package com.example.Pokemon.services;

import com.example.Pokemon.dtos.PlayerDTO;
import com.example.Pokemon.models.Player;
import com.example.Pokemon.repositories.PlayerRepository;
import com.example.Pokemon.repositories.PlayerRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerRepositoryCustom playerRepositoryCustom;

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(String id) {
        return playerRepository.findById(id);
    }

    public Optional<Player> getPlayerByNombre(String nombre) {
        return playerRepository.findByNombre(nombre);
    }

    public List<Player> getPlayersByNivelGreaterThan(int nivel) {
        return playerRepository.findByNivelGreaterThanEqual(nivel);
    }


    public List<Player> getPlayersByLogrosNombre(String nombreLogro) {
        return playerRepository.findByLogrosNombre(nombreLogro);
    }

    public int countPlayersByNivelGreaterThan(int nivel) {
        return playerRepository.countByNivelGreaterThanEqual(nivel);
    }

    public boolean register(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setNombre(playerDTO.getNombre());
        player.setNivel(playerDTO.getNivel());
        player.setEquipo(playerDTO.getEquipo());
        player.setLogros(playerDTO.getLogros());

        return playerRepository.save(player) != null;
    }

    public boolean deletePlayerById(String id) {
        try {
            playerRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deletePlayerByNombre(String nombre) {
        try {
            playerRepository.deleteByNombre(nombre);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void updatePlayer(String id, PlayerDTO playerDTO) {
        Optional<Player> playerOptional = playerRepository.findById(id);

        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();
            player.setNombre(playerDTO.getNombre());
            player.setNivel(playerDTO.getNivel());
            player.setEquipo(playerDTO.getEquipo());
            player.setLogros(playerDTO.getLogros());

            playerRepository.save(player);
        } else {
            throw new RuntimeException("No existe el jugador con id: " + id);
        }
    }

    public void patchPlayer(String id, PlayerDTO playerDTO) {
        Optional<Player> playerOptional = playerRepository.findById(id);

        if (playerOptional.isPresent()) {
            Player player = playerOptional.get();

            if (playerDTO.getNombre() != null) {
                player.setNombre(playerDTO.getNombre());
            }
            if (playerDTO.getNivel() != 0) {
                player.setNivel(playerDTO.getNivel());
            }
            if (playerDTO.getEquipo() != null) {
                player.setEquipo(playerDTO.getEquipo());
            }
            if (playerDTO.getLogros() != null) {
                player.setLogros(playerDTO.getLogros());
            }

            playerRepository.save(player);
        } else {
            throw new RuntimeException("No existe el jugador con id: " + id);
        }
    }

    // Métodos usando MongoTemplate

    public Player getPlayerByIdCustom(String id) {
        return playerRepositoryCustom.findById(id);
    }

    public List<Player> getPlayersByNivelGreaterThanCustom(int nivel) {
        return playerRepositoryCustom.findPlayersByNivelGreaterThan(nivel);
    }
}

