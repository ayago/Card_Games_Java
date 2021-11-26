package pusoydos.gameplay.domain;

public class Game {

    public final Player[] players;
    public final PlayedCards recentlyPlayedCards;
    private final Player recentPlayerPlayed;

    public Game(Player[] players, PlayedCards recentlyPlayedCards, Player recentPlayerPlayed) {
        this.players = players;
        this.recentlyPlayedCards = recentlyPlayedCards;
        this.recentPlayerPlayed = recentPlayerPlayed;
    }

    public Game playCards(PlayCardsCommand command){
        return this;
    }

    public Game start(StartCommand command){
        return this;
    }

    public Game pass(PassCommand command){
        return this;
    }
}
