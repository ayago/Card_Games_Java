package ayago.cardgame.pusoydos.domain.entity;

import ayago.cardgame.pusoydos.domain.GameState.CardState;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Card{

    private static final Map<String, Card> CARD_CACHE = new HashMap<>();

    public static Card resolveCard(Suit suit, Value value){
        return CARD_CACHE.computeIfAbsent(suit.name() + value.name(), key -> new Card(suit, value));
    }

    public static Card resolveCard(CardState cardState){
        return CARD_CACHE.get(cardState.getSuit() + cardState.getValue());
    }

    public final Suit suit;
    public final Value value;



    private Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }

    public enum Suit{

    }

    public enum Value{

    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return suit == card.suit && value == card.value;
    }

    @Override
    public int hashCode(){
        return Objects.hash(suit, value);
    }
}
