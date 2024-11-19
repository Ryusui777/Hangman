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

    public final String wordsFilePath = "src/model/entities/words.txt";
    public static final char[] chars = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".toCharArray();
    public String[] words;

    public Words(Model model) {
        this.model = model;
        this.words = readWordsFile();
    }

    private String[] readWordsFile(){
        ArrayList<String> words = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader(wordsFilePath));
            String line;
            while((line = br.readLine()) != null){
                line = line.strip();
                if(checkWord(line) && line.length() < 16){
                    words.add(line);
                }
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

    public String getRandomWord(){
        if(words.length == 0){
            model.errorHandling(WORDS_FILE_NOT_FOUND, wordsFilePath);
            return "Zelda";
        }
        int index = (int)(Math.random()*(words.length-1));
        return words[index];
    }

    public static boolean checkWord(String word){
        boolean found = true;
        for(char c : word.strip().toCharArray()){
            for(char c1: chars){
                if(c == c1 || c1 == Character.toUpperCase(c)){
                    found = true;
                    break;
                }
                found = false;
            }
        }
        return found;
    }
}
