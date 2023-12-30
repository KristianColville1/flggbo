package models;

import annotations.DBField;
import annotations.DBTable;
/**
 * Represents a player in the Fantasy Great British Bake-Off League.
 * This class stores information about the player, including their ID,
 * name, and email address.
 * <p>
 * Use this class to manage player data within the league.
 */
@DBTable(name="players")
public class Player {
    @DBField(name="playerId", primaryKey = true)
    private int playerId;

    @DBField(name="name")
    private String name;

    @DBField(name="email")
    private String email;

    public Player(int playerId, String name, String email) {
        this.playerId = playerId;
        this.name = name;
        this.email = email;
    }


}
