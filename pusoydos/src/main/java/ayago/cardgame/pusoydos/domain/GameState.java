package ayago.cardgame.pusoydos.domain;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class GameState{
    String gameId;
    String recentPlayerPlayedId;
    String nextPlayerId;
    PlayedCardsState recentlyPlayedCards;
    PlayerState[] players;

    @Value
    public static class CardState {
        String suit;
        String value;
    }

    @Value
    public static class PlayerState {
        String playerId;
        CardState[] remainingCards;
    }

    @Value
    public static class PlayedCardsState {
        CardState[] cards;
    }
}
