package daos.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import daos.interfaces.PlayerDAO;
import database.DatabaseConnector;
import models.Player;

public class PlayerDAOImpl implements PlayerDAO{
    @Override
    public void addPlayer(Player player) {
        String sql = "INSERT INTO players (playerId, name, email) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnector.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, player.getPlayerId());
            pstmt.setString(2, player.getName());
            pstmt.setString(3, player.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error adding player: " + e.getMessage());
        }
    }

    @Override
    public Player getPlayerById(int playerId) {
        String sql = "SELECT * FROM players WHERE playerId = ?";
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, playerId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Player(rs.getInt("playerId"), rs.getString("name"), rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println("Error getting player: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        String sql = "SELECT * FROM players";
        try (Connection conn = DatabaseConnector.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                players.add(new Player(rs.getInt("playerId"), rs.getString("name"), rs.getString("email")));
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving all players: " + e.getMessage());
        }
        return players;
    }

    @Override
    public void updatePlayer(Player player) {
        String sql = "UPDATE players SET name = ?, email = ? WHERE playerId = ?";
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, player.getName());
            pstmt.setString(2, player.getEmail());
            pstmt.setInt(3, player.getPlayerId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error updating player: " + e.getMessage());
        }
    }

    @Override
    public void deletePlayer(int playerId) {
        String sql = "DELETE FROM players WHERE playerId = ?";
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, playerId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error deleting player: " + e.getMessage());
        }
    }
}
