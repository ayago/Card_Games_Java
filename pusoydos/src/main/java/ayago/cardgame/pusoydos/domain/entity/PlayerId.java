package ayago.cardgame.pusoydos.domain.entity;

import java.util.Objects;

public class PlayerId{

    public final String value;

    PlayerId(String value){
        this.value = Objects.requireNonNull(value, "Player Id cannot be null");
    }
}
