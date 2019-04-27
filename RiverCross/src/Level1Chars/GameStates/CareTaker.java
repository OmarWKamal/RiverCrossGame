package Level1Chars.GameStates;

import Level1Chars.GameStates.Memento;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.Stack;

public class CareTaker {
    //ArrayList<Memento> gamestates = new ArrayList<Memento>();
    Stack <Memento> gamestatesUndo = new Stack<Memento>();

    public Stack<Memento> getGamestatesUndo() {
        return gamestatesUndo;
    }

    public void setGamestatesUndo(Stack<Memento> gamestatesUndo) {
        this.gamestatesUndo = gamestatesUndo;
    }

    public Stack<Memento> getGamestatesRedo() {
        return gamestatesRedo;
    }

    public void setGamestatesRedo(Stack<Memento> gamestatesRedo) {
        this.gamestatesRedo = gamestatesRedo;
    }

    Stack <Memento> gamestatesRedo = new Stack<Memento>();

    public void addMemento (Memento memento) {
        gamestatesUndo.push(memento);
    }
    public Memento getMementoUndoChar(){
        gamestatesRedo.push(gamestatesUndo.pop()); //bec the last element is the current gamestate
        if(gamestatesUndo.empty()){
            return null;
        }
        return gamestatesUndo.pop();
        }

    public Memento getMementoUndoMove(int rowers){
        //gamestatesRedo.push(gamestatesUndo.pop());
        for(int i = 0 ; i < rowers; i++) {
            gamestatesUndo.pop();
        }
        return gamestatesUndo.pop();
    }


    public Memento getMementoRedo(int index){
        gamestatesUndo.push(gamestatesRedo.peek());
        return gamestatesRedo.pop();}


    public int mementoSize(){
        return this.gamestatesUndo.size();
    }

    public void clearStacks() {
        gamestatesUndo.clear();
        gamestatesRedo.clear();
    }
}


 /*System.out.println(index +   "     weeeeeeeee ");
        if(mementoSize() - index < 0){
            Alert max = new Alert(Alert.AlertType.INFORMATION);
            max.setContentText("No more undos!!");
            max.showAndWait();
            return null;
        }
        else {
            System.out.println(mementoSize() + " memento array size");
            return gamestates.get(gamestates.size() - index);
        }*/
