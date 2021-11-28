package ayago.cardgame.pusoydos.domain;

import ayago.cardgame.pusoydos.domain.event.GameEvent;

import java.util.List;

public interface GameEventPublisher{
    void publish(List<? extends GameEvent> events);
}
