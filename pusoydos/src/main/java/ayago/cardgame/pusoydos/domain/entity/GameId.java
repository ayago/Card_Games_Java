package ayago.cardgame.pusoydos.domain.entity;

import java.util.Objects;

public class GameId{
    public final String value;

    public GameId(String value){
        this.value = Objects.requireNonNull(value, "Game Id cannot be null");
    }
}
