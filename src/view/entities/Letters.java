package view.entities;

import view.View;
import view.entities.gResources.Graphics;

import javax.swing.*;
import java.awt.*;

public class Letters {
    private final Graphics g;
    private final JPanel panel;
    private final Letter[] lettersLabels;
    private final View view;

    public Letters(int width, int height, int posX, int posY, Graphics g, View view) {

        panel = new JPanel();
        panel.setBounds(posX, posY, width, height);
        panel.setLayout(new GridLayout(3, 9));
        panel.setBackground(Color.BLACK);

        this.g = g;
        this.lettersLabels = new Letter[g.alphabet.length];
        this.view = view;
        showAlphabet();
    }

    private void showAlphabet(){
        for(int i = 0; i < lettersLabels.length; i++){
            lettersLabels[i] = new Letter(g.alphabet[i], view, i);
            panel.add(lettersLabels[i]);
        }
    }

    public void reset(){
        for(int index = 0; index < lettersLabels.length; index++){
            lettersLabels[index].setDefaultColor();
        }
    }

    public void changeLetter(int index, boolean color){
        if(color){
            lettersLabels[index].setGood();
        }
        else{
            lettersLabels[index].setBad();
        }

    }

    private class Letter extends JButton {
        private static final Color defaultColor = Color.BLACK;
        private static final Color good = new Color(0,100,0);
        private static final Color bad = new Color(100,0,0);


        public Letter(ImageIcon icon, View view, int number){
            setLayout(new FlowLayout());
            setFocusable(false);
            setIcon(icon);
            setBackground(defaultColor);
            addActionListener(e -> view.letterPressed(number));
        }

        public void setBad(){
            setBackground(bad);
        }

        public void setGood(){
            setBackground(good);
        }

        public void setDefaultColor(){
            setBackground(defaultColor);
        }

    }

    public JPanel getPanel() {
        return panel;
    }
}
