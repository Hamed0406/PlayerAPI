package com.example.demo.Exception;

public class PlayerNotFoundException extends  RuntimeException{
    public PlayerNotFoundException(Long id) {
        super("Could not find player " + id);
    }
}
