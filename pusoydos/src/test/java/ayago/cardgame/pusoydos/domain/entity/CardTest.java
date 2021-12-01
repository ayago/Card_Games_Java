package ayago.cardgame.pusoydos.domain.entity;

import ayago.cardgame.pusoydos.domain.entity.Card.Suit;
import ayago.cardgame.pusoydos.domain.entity.Card.Value;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CardTest{

    @ParameterizedTest
    @MethodSource("resolveCardParam")
    void resolveCard(Suit expectedSuit, Value expectedValue){
        Card resolvedCard = Card.resolveCard(expectedSuit, expectedValue);

        assertNotNull(resolvedCard);
        assertAll(
            () -> assertEquals(expectedSuit, resolvedCard.suit),
            () -> assertEquals(expectedValue, resolvedCard.suit)
        );
    }

    private static Stream<Arguments> resolveCardParam(){
        return stream(Suit.values())
            .flatMap(suit -> stream(Value.values()).map(value -> Arguments.of(suit, value)));
    }
}
