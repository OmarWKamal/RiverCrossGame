package Level1Chars.GameStates;

import Level1Chars.GameStates.Memento;

import java.util.ArrayList;

public class Originator {
    public void setGameState(Object gameState) {
        this.gameState = gameState;
    }

    private Object gameState;

    public Memento saveMemento(){
        return new Memento(gameState);
    }

    public Object restoreFromMemento(Memento memento){
        this.gameState = memento.getCharState();
        return gameState;
    }


}
