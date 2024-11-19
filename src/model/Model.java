package model;

import controller.Controller;
import controller.entities.Errors;
import model.entities.LetterSelection;
import model.entities.Words;

public class Model {

    private Words words;
    private LetterSelection letterSelection;
    private Controller controller;

    public Model(Controller controller) {
        this.controller = controller;
        words = new Words(this);
        letterSelection = new LetterSelection();
    }

    public int getSelectionState(int index){
        return letterSelection.getState(index);
    }

    public void setSelectionState(int index, int state){
        letterSelection.setSelection(index, state);
    }

    public void reset(){
        letterSelection.reset();
    }

    public String getRandomWord(){
        return words.getRandomWord();
    }

    public char[] getAlphabet(){
        return Words.chars;
    }



    public void errorHandling(Errors error, String arg){
        controller.errorHandler(error, arg);
    }
}
