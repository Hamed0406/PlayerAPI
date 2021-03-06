package com.example.demo.Controller;


import com.example.demo.Entitites.Player;
import com.example.demo.Exception.PlayerNotFoundException;
import com.example.demo.Repository.PlayerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class PlayerController {

    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    // Aggregate root
    // tag::get-aggregate-root[]

    @GetMapping("/players")
    @CrossOrigin()

    List<Player> all() {
        return playerRepository.findAll();
    }
    // end::get-aggregate-root[]
    @CrossOrigin()

    @PostMapping("/players")

    Player newPlayer(@RequestBody Player newPlayer) {
        return playerRepository.save(newPlayer);
    }

    // Single item
    @CrossOrigin()

    @GetMapping("/players/{id}")

    Player one(@PathVariable Long id) {

        return playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException(id));
    }
    @CrossOrigin()

    @PutMapping("/players/{id}")

    Player replacePlayer(@RequestBody Player newPlayer, @PathVariable Long id) {

        return playerRepository.findById(id)
                .map(player -> {
                    player.setPlayerName(newPlayer.getPlayerName());
                    player.setPlayerAge(newPlayer.getPlayerAge());
                    player.setPlayerNumber(newPlayer.getPlayerNumber());
                    player.setPlayerBirthDate(newPlayer.getPlayerBirthDate());
                    return playerRepository.save(player);
                })
                .orElseGet(() -> {
                    newPlayer.setId(id);
                    return playerRepository.save(newPlayer);
                });
    }

    @DeleteMapping("/players/{id}")
    @CrossOrigin()

    void deletePlayer(@PathVariable Long id) {
        playerRepository.deleteById(id);
    }
}
