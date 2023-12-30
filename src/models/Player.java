package models;

import annotations.DBTable;

@DBTable(name="players")
public class Player {
    private int playerId;
    private String name;
    private String email;

    public Player(int playerId, String name, String email) {
        this.playerId = playerId;
        this.name = name;
        this.email = email;
    }


}
