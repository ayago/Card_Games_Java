package ayago.cardgame.pusoydos.domain.entity;

import ayago.cardgame.pusoydos.domain.GameState.PlayerState;

import java.util.Arrays;

public class Player{
    public final PlayerId playerId;
    public final Card[] cards;

    Player(PlayerState playerState){
        this.playerId = new PlayerId(playerState.getPlayerId());
        this.cards = Arrays.stream(playerState.getRemainingCards())
            .map(Card::resolveCard)
            .toArray(Card[]::new);
    }

    private Player(PlayerId playerId, Card[] cards){
        this.playerId = playerId;
        this.cards = cards;
    }

    Player(String playerIdValue){
        this.playerId = new PlayerId(playerIdValue);
        this.cards = new Card[0];
    }

    Player allocateCards(Card[] allocatedCards){
        return new Player(this.playerId, allocatedCards);
    }


}
