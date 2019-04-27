package Level1Chars.GameStates;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    public Object getCharState() {
        return gameState;
    }

    private Object gameState;

    public Memento(Object gameState) {
        this.gameState = gameState;
    }
}
