package ayago.cardgame.pusoydos.domain.entity;

import ayago.cardgame.pusoydos.domain.GameState.CardState;

import java.util.Map;
import java.util.Objects;

import static java.util.Arrays.stream;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toUnmodifiableMap;

public class Card{

    private static final Map<String, Card> CARD_CACHE;

    static{
        CARD_CACHE = stream(Suit.values())
            .flatMap(suit -> stream(Value.values()).map(value -> new Card(suit, value)))
            .collect(toUnmodifiableMap(card -> card.suit.name() + card.value.name(), identity()));
    }

    public static Card resolveCard(Suit suit, Value value){
        return CARD_CACHE.get(suit.name() + value.name());
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
        CLOVER('C'),
        SPADES('S'),
        HEARTS('H'),
        DIAMONDS('D');

        public final char code;

        Suit(char code){
            this.code = code;
        }
    }

    public enum Value{
        ACE('A'),
        TWO('2'),
        THREE('3'),
        FOUR('4'),
        FIVE('5'),
        SIX('6'),
        SEVEN('7'),
        EIGHT('8'),
        NINE('9'),
        TEN('T'),
        JACK('J'),
        QUEEN('Q'),
        KING('K');

        public final char code;

        Value(char code){
            this.code = code;
        }
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
