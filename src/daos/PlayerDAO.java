package daos;

import models.Player;
import java.util.List;

public interface PlayerDAO {
    void addPlayer(Player player);
    Player getPlayerById(int playerId);
    List<Player> getAllPlayers();
    void updatePlayer(Player player);
    void deletePlayer(int playerId);
}
