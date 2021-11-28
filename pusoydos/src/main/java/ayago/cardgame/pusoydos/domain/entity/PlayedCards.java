package ayago.cardgame.pusoydos.domain.entity;

import ayago.cardgame.pusoydos.domain.GameState.PlayedCardsState;

import java.util.Arrays;

public class PlayedCards{
    public final Card[] cards;

    PlayedCards(PlayedCardsState state){
        this.cards = Arrays.stream(state.getCards())
            .map(Card::resolveCard)
            .toArray(Card[]::new);
    }

    PlayedCards(Card[] cards){
        this.cards = cards;
    }

    private enum CardOrder {

    }
}
