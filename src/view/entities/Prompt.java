package view.entities;
import controller.entities.Errors;
import view.View;
import view.entities.gResources.Graphics;

import javax.swing.*;
import java.awt.*;

public class Prompt extends JPanel{
    private final Graphics g;
    private final JPanel panel;
    private final int width, height;
    private final int screenWidth;
    private final int posY;
    private Letter[] letters;
    private View view;

    public Prompt(Graphics g, int height, int width, int screenWidth, int posY, View view) {
        this.g = g;
        this.view = view;
        this.posY = posY;
        this.width = width;
        this.height = height;
        this.panel = new JPanel();
        this.screenWidth = screenWidth;
        this.panel.setBackground(Color.BLACK);
        this.panel.setLayout(new GridLayout(1, 0));
    }

    public JPanel getPanel(){
        return panel;
    }

    public void show(String word){

        // Removes everything from the panel
        panel.removeAll();

        // Changing the position and width
        int width = this.width*word.length();
        int posX = screenWidth/2-width/2;

        // Setting new dimensions and position
        panel.setBounds(posX,posY,width,height);
        panel.setLayout(new GridLayout(1,word.length()));

        //
        letters = new Letter[word.length()];

        for(int index = 0; index < word.length(); index++){
            letters[index] = new Letter(g.blank);
            panel.add(letters[index]);
        }

    }

    public void reset(String word){
        show(word);
    }

    public void setCharAt(int index, char c){

        if(getLetter(c) == null){
            view.errorHandling(Errors.INTERNAL_ERROR_VIEW ,"in Prompt");
            return;
        }
        letters[index].changeIcon(getLetter(c));
    }

    private ImageIcon getLetter(char letter){
        char [] chars = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".toCharArray();
        ImageIcon icon = null;
        for(int index = 0; index < chars.length; index++){
            if(chars[index] == Character.toUpperCase(letter)){
                icon = g.alphabet[index];
            }
        }
        return icon;
    }

    private class Letter extends JLabel{
        public Letter(ImageIcon icon){
            setIcon(icon);
            setBackground(Color.BLACK);
        }
        public void changeIcon(ImageIcon icon){
            setIcon(icon);
        }
    }





}
