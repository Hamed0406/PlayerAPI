package com.example.demo.Entitites;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Player {
    private @Id
    @GeneratedValue long id;
    private String playerName;
    private int playerAge;
    private int playerNumber;
    private long playerBirthDate;


    public Player() {
    }

    public Player(String playerName, int playerAge, int playerNumber, long playerBirthDate) {
        this.playerName = playerName;
        this.playerAge = playerAge;
        this.playerNumber = playerNumber;
        this.playerBirthDate = playerBirthDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(int playerAge) {
        this.playerAge = playerAge;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public long getPlayerBirthDate() {
        return playerBirthDate;
    }

    public void setPlayerBirthDate(long playerBirthDate) {
        this.playerBirthDate = playerBirthDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id == player.id && playerAge == player.playerAge && playerNumber == player.playerNumber && playerBirthDate == player.playerBirthDate && Objects.equals(playerName, player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerName, playerAge, playerNumber, playerBirthDate);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", playerName='" + playerName + '\'' +
                ", playerAge=" + playerAge +
                ", playerNumber=" + playerNumber +
                ", playerBirthDate=" + playerBirthDate +
                '}';
    }
}



