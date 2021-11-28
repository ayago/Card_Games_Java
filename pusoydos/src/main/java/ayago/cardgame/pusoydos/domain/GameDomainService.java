package ayago.cardgame.pusoydos.domain;

import ayago.cardgame.pusoydos.domain.command.JoinCommand;
import ayago.cardgame.pusoydos.domain.command.NewGameCommand;
import ayago.cardgame.pusoydos.domain.command.PassCommand;
import ayago.cardgame.pusoydos.domain.command.PlayCardsCommand;
import ayago.cardgame.pusoydos.domain.command.QuitGameCommand;
import ayago.cardgame.pusoydos.domain.command.StartCommand;
import ayago.cardgame.pusoydos.domain.entity.Game;

public final class GameDomainService{

    private final GameRepository repository;
    private final GameEventPublisher eventPublisher;

    public GameDomainService(GameRepository repository, GameEventPublisher eventPublisher){
        this.repository = repository;
        this.eventPublisher = eventPublisher;
    }

    public void newGame(NewGameCommand command){
        //TODO implement properly
        Game newGame = new Game(generateGameIdValue(), command.getAccountId());
        repository.save(newGame.generateState());
        eventPublisher.publish(newGame.gameEvents);
    }

    public void joinGame(JoinCommand command){

    }

    public void start(StartCommand command){

    }

    public void quitGame(QuitGameCommand command){

    }

    public void playCards(PlayCardsCommand command){

    }

    public void passTurn(PassCommand command){

    }

    private static String generateGameIdValue(){
        //TODO: Implement using UUID
        return "GHGHGH";
    }
}
