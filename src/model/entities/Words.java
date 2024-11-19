package model.entities;
import model.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;

import static controller.entities.Errors.CHARACTER_NOT_SUPPORTED;
import static  controller.entities.Errors.WORD_LENGTH_EXCEEDED;
import static controller.entities.Errors.WORDS_FILE_NOT_FOUND;

public class Words {

    Model model;
    public String[] words;

    // Path for the words file
    public final String wordsFilePath = "src/model/entities/words.txt";

    // Array of the valid chars
    public static final char[] chars = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".toCharArray();

    // Constructor takes model as argument, mainly to handle errors
    public Words(Model model) {
        this.model = model;
        this.words = readWordsFile();
    }

    // Reads the words file
    private String[] readWordsFile(){

        ArrayList<String> words = new ArrayList<>();

        try{

            // BufferedReader to read the file
            BufferedReader br = new BufferedReader(new FileReader(wordsFilePath));

            // String to iterate over the file
            String line;

            while((line = br.readLine()) != null){

                line = line.strip();

                if(checkWord(line) && line.length() < 16){
                    words.add(line);
                }

                // Maximum length is 17, but to make sure it doesn't fail I decreased it by 1
                else if(line.length() > 16){
                    model.errorHandling(WORD_LENGTH_EXCEEDED, line);
                }

                else{
                    model.errorHandling(CHARACTER_NOT_SUPPORTED, line);
                }
            }

        }
        catch (IOException e){
            model.errorHandling(WORDS_FILE_NOT_FOUND, wordsFilePath);
        }
        return words.toArray(new String[0]);
    }

    // returns a random word, if a problem rises returns Zelda by default
    public String getRandomWord(){
        if(words.length == 0){
            model.errorHandling(WORDS_FILE_NOT_FOUND, wordsFilePath);
            return "Zelda";
        }
        int index = (int)(Math.random()*(words.length-1));
        return words[index];
    }

    // Checks if all the characters in a word are valid
    public static boolean checkWord(String word){
        boolean found = false;
        for(char c : word.strip().toCharArray()){
            for(char c1: chars){
                if(c1 == Character.toUpperCase(c)){
                    found = true;
                    break;
                }
                found = false;
            }
        }
        return found;
    }
}
