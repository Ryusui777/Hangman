package view.entities;

import view.View;
import view.entities.gResources.Graphics;

import javax.swing.JFrame;
import java.awt.Color;

public class Window {

    private final View view;
    private final Prompt prompt;

    // The width and the height of the frame
    public static final int width = 1400;
    public static final int height = (int)(width*0.6666666667);

    // The width and the height of the gallows panel
    public static final int gallowsWidth = (int)(width * 0.5);
    public static final int gallowsHeight = (int)(height * 0.5);
    public static final int gallowsPosX = (int)(width*0.55);
    public static final int gallowsPosY = (int)(height * 0.3 - gallowsHeight*0.5);

    // The width and the height of the letters panel
    public static final int lettersWidth = gallowsWidth;
    public static final int lettersHeight = gallowsHeight;
    public static final int lettersPosX = width/70;
    public static final int lettersPosY = gallowsPosY;


    // The dimensions of the prompt
    public static final int promptHeight = lettersHeight/3;
    public static final int promptWidth = lettersWidth/9;
    public static final int promptPosY = (int)(height * 0.7);

    // Reset Button dimensions
    public static final int resetWidth = width/9;
    public static final int resetHeight = height/14;
    public static final int resetPosX = lettersPosX;
    public static final int resetPosY = lettersPosY+lettersHeight+lettersPosX;

    public Window(View view) {

        // Setting up Frame
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Setting view
        this.view = view;

        // Loading graphics
        Graphics graphics = new Graphics(width, height, gallowsWidth, gallowsHeight, resetWidth, resetHeight, view);

        // Setting up components
        Gallows gallows = new Gallows(gallowsWidth, gallowsHeight, gallowsPosX, gallowsPosY, graphics, view);
        Letters letters = new Letters(lettersWidth, lettersHeight, lettersPosX, lettersPosY, graphics);
        this.prompt = new Prompt(graphics, promptHeight, promptWidth, width, promptPosY, view);
        ResetButton resetButton = new ResetButton(resetWidth, resetHeight, resetPosX, resetPosY, graphics, view);

        frame.add(gallows.getPanel());
        frame.add(letters.getPanel());
        frame.add(prompt.getPanel());
        frame.add(resetButton);
        prompt.show("12345678901234567");

        // Making frame visible
        frame.setVisible(true);
    }

    // Method to change a character in a certain position of the prompt
    public void changeCharInPrompt(int index, char c){
        prompt.setCharAt(index, c);
    }






}
