package ayago.cardgame.pusoydos.domain.entity;

import ayago.cardgame.pusoydos.domain.GameState;
import ayago.cardgame.pusoydos.domain.command.JoinCommand;
import ayago.cardgame.pusoydos.domain.command.PassCommand;
import ayago.cardgame.pusoydos.domain.command.PlayCardsCommand;
import ayago.cardgame.pusoydos.domain.command.QuitGameCommand;
import ayago.cardgame.pusoydos.domain.command.StartCommand;
import ayago.cardgame.pusoydos.domain.event.GameEvent;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Game{

    public final GameId gameId;
    public final Player[] players;
    private final PlayedCards recentlyPlayedCards;
    private final PlayerId recentPlayerPlayed;
    private final PlayerId nextPlayer;
    public final List<? extends GameEvent> gameEvents = Collections.emptyList();

    public Game(String gameId, String gameCreatorId){
        this.gameId = new GameId(gameId);
        this.recentlyPlayedCards = null;
        this.players = new Player[]{new Player(gameCreatorId), null, null, null};
        this.recentPlayerPlayed = null;
        this.nextPlayer = null;
    }

    public Game(GameState gameState){
        this.gameId = new GameId(gameState.getGameId());
        this.players = Arrays.stream(gameState.getPlayers())
            .map(Player::new)
            .toArray(Player[]::new);

        this.recentlyPlayedCards = new PlayedCards(gameState.getRecentlyPlayedCards());
        this.recentPlayerPlayed = new PlayerId(gameState.getRecentPlayerPlayedId());
        this.nextPlayer = new PlayerId(gameState.getNextPlayerId());
    }

    Game joinGame(JoinCommand command){
        return this;
    }

    Game start(StartCommand command){
        return this;
    }

    Game quitGame(QuitGameCommand command){
        return this;
    }

    Game playCards(PlayCardsCommand command){
        return this;
    }

    Game passTurn(PassCommand command){
        return this;
    }

    public Optional<PlayerId> getRecentPlayerPlayed(){
        return Optional.ofNullable(recentPlayerPlayed);
    }

    public Optional<PlayerId> getNextPlayer(){
        return Optional.ofNullable(nextPlayer);
    }

    public Optional<PlayedCards> getRecentlyPlayedCards(){
        return Optional.ofNullable(recentlyPlayedCards);
    }

    public GameState generateState(){
        return GameState.builder().build();
    }
}
