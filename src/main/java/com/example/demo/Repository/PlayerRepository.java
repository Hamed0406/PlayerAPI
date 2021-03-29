package com.example.demo.Repository;

import com.example.demo.Entitites.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {
}
