package controller;

import controller.entities.ErrorHandler;
import controller.entities.Errors;
import model.Model;
import view.View;

import java.util.Arrays;

public class Controller {
    private enum PlayerState{
        NONE(0),
        HEAD(1),
        BODY(2),
        ARMS(3),
        LEGS(4),
        ABOUT_TO_DIE(11),
        DEAD(5),
        VIVA_LA_VIDA(6)
        ;

        final int state;
        PlayerState(int state){
            this.state = state;
        }
    }

    private Model model;
    private View view;
    private PlayerState playerState;
    private String word;
    private char[] playerGuess;
    private boolean playerDied;
    private boolean playerWon;

    public Controller(){
        playerState = PlayerState.NONE;
    }

    public void setUp(Model model, View view){
        this.model = model;
        this.view = view;
        this.word = model.getRandomWord();
        this.playerGuess = new char[word.length()];
        Arrays.fill(playerGuess, ' ');
        this.view.showPrompt(word);
    }



    public void letterPressed(int index) {
        // Prevent interaction if the game is over
        if (playerDied || playerWon) {
            return;
        }

        // Check if the letter has not been selected yet
        if (model.getSelectionState(index) == 0) {
            char guessedLetter = model.getAlphabet()[index];

            // If the guessed letter is in the word
            if (checkInWord(guessedLetter)) {
                view.setLetter(index, true); // Mark the letter as correct in the view

                // Update the view and player's progress
                for (int i = 0; i < word.length(); i++) {
                    if (Character.toUpperCase(word.charAt(i)) == guessedLetter) {
                        view.changeLetterInPrompt(guessedLetter, i); // Reveal letter in prompt
                        playerGuess[i] = word.charAt(i); // Update player's guess array
                    }
                }
            } else {
                // If the guessed letter is not in the word
                view.setLetter(index, false); // Mark the letter as incorrect in the view
                changeScene(); // Trigger game response (e.g., reduce life, update graphics)
            }

            // Mark the letter as selected
            model.setSelectionState(index, 1);

            // Check if the player has won
            checkWinState();
        }
    }

    // Checks if the player has won or lost
    private void checkWinState(){
        StringBuilder guess = new StringBuilder();
        for(char letter : playerGuess){
            guess.append(letter);
        }
        if(guess.toString().equals(word)){
            view.changeGalloeScene(PlayerState.VIVA_LA_VIDA.state);
            playerState = PlayerState.VIVA_LA_VIDA;
            System.out.println("A player won!");
            playerWon = true;
        }
        else if(playerState == PlayerState.ABOUT_TO_DIE){
            view.changeGalloeScene(PlayerState.DEAD.state);
            playerState = PlayerState.DEAD;
            playerDied = true;
        }
    }

    public void reset(){
        this.word = model.getRandomWord();
        this.playerGuess = new char[word.length()];
        Arrays.fill(playerGuess, ' ');
        this.playerDied = false;
        this.playerWon = false;
        this.view.reset(this.word);
        this.playerState = PlayerState.NONE;
        this.model.reset();
    }

    private void changeScene(){
        if(playerState == PlayerState.NONE){
            view.changeGalloeScene(PlayerState.HEAD.state);
            playerState = PlayerState.HEAD;
        }
        else if(playerState == PlayerState.HEAD){
            view.changeGalloeScene(PlayerState.BODY.state);
            playerState = PlayerState.BODY;
        }
        else if(playerState == PlayerState.BODY){
            view.changeGalloeScene(PlayerState.ARMS.state);
            playerState = PlayerState.ARMS;
        }
        else if(playerState == PlayerState.ARMS){
            view.changeGalloeScene(PlayerState.LEGS.state);
            playerState = PlayerState.LEGS;
        }
        else if(playerState == PlayerState.LEGS){
            view.changeGalloeScene(PlayerState.LEGS.state);
            playerState = PlayerState.ABOUT_TO_DIE;
        }
    }

    private boolean checkInWord(char letter){
        boolean inWord = false;
        for(int indice = 0; indice < word.length(); indice++){
            if(Character.toUpperCase(word.charAt(indice)) == Character.toUpperCase(letter)){
                inWord = true;
                break;
            }
        }

        return inWord;
    }

    public void errorHandler(Errors error, String message){
        ErrorHandler.error(error, message);
    }

}
