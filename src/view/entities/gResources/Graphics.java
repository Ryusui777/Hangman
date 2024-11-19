package view.entities.gResources;

import view.View;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Graphics {


    public  ImageIcon gallows;
    public  ImageIcon head;
    public  ImageIcon body;
    public  ImageIcon arms;
    public  ImageIcon legs;
    public ImageIcon [] alphabet;
    public ImageIcon blank;
    public ImageIcon reset;
    public ImageIcon death;
    public ImageIcon happy;
    // If something goes wrong while loading graphics this come true
    public static boolean resourceError = false;

    public Graphics(int screenWidth, int screenHeight, int lettersWidth, int lettersHeight, int resetWidth, int resetHeight, View view) {
        // Loading graphic resources
        gallows = getGraphic(screenWidth, screenHeight, "Gallows.png");
        head = getGraphic(screenWidth, screenHeight, "Head.png");
        body = getGraphic(screenWidth, screenHeight, "Body.png");
        arms = getGraphic(screenWidth, screenHeight, "Arms.png");
        legs = getGraphic(screenWidth, screenHeight, "Legs.png");
        death = getGraphic(screenWidth, screenHeight, "Death.png");
        happy = getGraphic(screenWidth, screenHeight, "Happy.png");
        alphabet = getAlphabet(lettersWidth, lettersHeight);
        reset = getReset(resetWidth, resetHeight);
    }

    private ImageIcon getReset(int width, int height) {
        ImageIcon reset = new ImageIcon(Objects.requireNonNull(getClass().getResource("Reset.png")));
        Image image = reset.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(image);
    }

    private ImageIcon getGraphic(int width, int height, String path) {
        try {
            ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(path)));
            Image image = imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(image);
        }
        catch (Exception e) {
            resourceError = true;
        }

        return null;

    }

    private ImageIcon[] getAlphabet(int width, int height) {
        ImageIcon [] alphabet = new ImageIcon[27];
        blank = new ImageIcon(Objects.requireNonNull(getClass().getResource("Blank.png")));
        Image blankImage = blank.getImage().getScaledInstance(width/9, (int)(height*0.2), Image.SCALE_SMOOTH);
        blank = new ImageIcon(blankImage);
        char [] chars = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ".toCharArray();

        try {
            for (int index = 0; index < alphabet.length; index++) {
                ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource(chars[index] + ".png")));
                Image image = icon.getImage().getScaledInstance((int)(width/9), (int)(height*0.2), Image.SCALE_SMOOTH);
                alphabet[index] = new ImageIcon(image);
            }
            return alphabet;
        }
        catch (Exception e) {
            resourceError = true;
        }
        return null;

    }

}
