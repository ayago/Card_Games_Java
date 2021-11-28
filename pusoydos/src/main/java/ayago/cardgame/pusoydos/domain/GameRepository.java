package ayago.cardgame.pusoydos.domain;

import java.util.Optional;

public interface GameRepository{
    Optional<GameState> retrieveGame(String gameId);

    boolean accountAvailable(String accountId);

    void save(GameState gameState);
}
