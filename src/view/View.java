package view;

import controller.Controller;
import controller.entities.Errors;
import view.entities.Window;

public class View {

    private Window window;
    private Controller controller;

    public View(Controller controller) {
        this.controller = controller;
        window = new Window(this);
    }

    public void changeGalloeScene(int scene){
        window.changeGallows(scene);
    }

    public void showPrompt(String prompt) {
        window.promptWord(prompt);

    }

    public void errorHandling(Errors error, String message){

    }

    public void resetPressed(){
        controller.reset();
    }

    public void reset(String word){
        window.reset(word);
    }

    public void letterPressed(int number){
        controller.letterPressed(number);
    }

    public void changeLetterInPrompt(char letter, int index){
        window.changeCharInPrompt(index, letter);
    }

    // Sets the color for a letter on the letter selection
    public void setLetter(int index, boolean color){
        window.changeLetters(index, color);
    }

}

